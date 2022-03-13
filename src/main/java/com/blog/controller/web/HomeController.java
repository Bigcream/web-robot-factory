package com.blog.controller.web;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.blog.entity.NewEntity;
import com.blog.entity.RoleEntity;
import com.blog.entity.UserEntity;

import com.blog.repository.RoleRepository;
import com.blog.repository.UserRepository;
import com.blog.service.IUserService;
import com.blog.service.impl.UserService;
import com.blog.util.SessionUtill;
import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;

@Controller(value = "homeControllerOfWeb")
public class HomeController {
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private SessionUtill sessionUtill;

	@RequestMapping(value = "/Home", method = RequestMethod.GET)
	public ModelAndView homePage(HttpServletRequest Request) {
		ModelAndView mav = new ModelAndView("web/home");

		return mav;
	}
	@RequestMapping(value = "/Login", method = RequestMethod.GET)
	public ModelAndView loginPage(Model model) {
		UserEntity user = new UserEntity();
		ModelAndView mav = new ModelAndView("login");
		
		//đấy user ra view để mapping nếu có register
		model.addAttribute("user", user);
		return mav;
	}
	@RequestMapping(value = "/Register", method = RequestMethod.POST)
	@Transactional
	public ModelAndView registerPage(@ModelAttribute("user") UserEntity user) {
		
		//kiểm tra pass có trùng nhau không
		if (user.getPassword().equals(user.getRepeatPassword())) {
			
			// mã hóa mật khẩu md5
		    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		    String encodedPassword = passwordEncoder.encode(user.getPassword());
		    user.setPassword(encodedPassword);
		    
		    //set status là đang active
		    user.setStatus(1);
		    Set<RoleEntity> role = new HashSet<RoleEntity>();
		    RoleEntity roles = roleRepository.findOne(2L);
		    role.add(roles);
		    user.setRoles(role);
		    
		    // set account mới mặc định là user 
			userRepo.save(user);
		}
		return new ModelAndView("redirect:/Login");
	}
	@RequestMapping(value = "/Logout", method = RequestMethod.GET)
	public ModelAndView logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return new ModelAndView("redirect:/Home");
	}
	
	//không có quyền sẽ redirect lại login
	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public ModelAndView accessDenied() {
		return new ModelAndView("redirect:/Login?accessDenied");
	}
}
