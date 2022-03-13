package com.blog.controller.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.blog.dto.AddressDTO;
import com.blog.dto.CartDTO;
import com.blog.dto.ItemDTO;
import com.blog.dto.ProductDTO;
import com.blog.service.IProductService;
import com.blog.util.SessionUtill;

@Controller(value = "cartControllerOfWeb")
public class CartController {
	@Autowired
	private IProductService productService;

	@Autowired
	private SessionUtill sessionUtill;
	


	@RequestMapping(value = "/Cart", method = RequestMethod.GET)
	public ModelAndView cartPage(HttpSession session, HttpServletRequest request) {
		
		Object object = sessionUtill.getInstance().getValue(session, "cart");
		AddressDTO addressDTO = new AddressDTO();
		ProductDTO model = new ProductDTO();
		CartDTO cartDTO = null;
		Long quantity = 1l;
		
		//kiểm tra cart rỗng thì sẽ tạo cart mới
		if (object != null) {
			cartDTO = (CartDTO) object;
		} else {
			cartDTO = new CartDTO();
		}
		SessionUtill.getInstance().putValue(request, "cart", cartDTO);
		ModelAndView mav = new ModelAndView("web/order/cart");
		mav.addObject("addressDTO", addressDTO);
		return mav;
	}
	@RequestMapping(value = "/Cart/{id}", method = RequestMethod.POST)
	public ModelAndView cartPostPage(@PathVariable Long id, HttpSession session,
			@RequestParam(value = "quantity", required = false) Long quantity) {
		Object object = sessionUtill.getInstance().getValue(session, "cart");

		ProductDTO model = new ProductDTO();
		CartDTO cartDTO = null;
		if (object != null) {
			cartDTO = (CartDTO) object;
		} else {
			cartDTO = new CartDTO();
		}
		
		// lấy ra product cần thêm
		model = productService.findById(id);
		float price = (float) (model.getPrice());
		
		// tạo ra class item
		ItemDTO itemDTO = new ItemDTO(model, quantity, price);
		
		//thêm item vào cart
		cartDTO.addItem(itemDTO);
		List<ItemDTO> listItem = cartDTO.getItems();
		cartDTO.setTotalMoney(cartDTO.getTotalMoney());
		
		//đẩy ra view
		SessionUtill.getInstance().putValue(session, "cart", cartDTO);
		SessionUtill.getInstance().putValue(session, "size", listItem.size());
		SessionUtill.getInstance().putValue(session, "totalProduct", cartDTO.getTotalProduct());
		int page = (int) SessionUtill.getInstance().getValue(session, "page");

		return new ModelAndView("redirect:/Product-detail/" + id);
	}
	@RequestMapping(value = "/Remove-item/{id}", method = RequestMethod.GET)
	public ModelAndView removeItem(@PathVariable Long id, HttpSession session) {
		CartDTO cartDTO = (CartDTO) sessionUtill.getInstance().getValue(session, "cart");
		AddressDTO addressDTO = new AddressDTO();
		ProductDTO model = new ProductDTO();
		
		//lấy ra product cần xóa
		model = productService.findById(id);
		float price = (float) (model.getPrice());
		
		//xóa item
		cartDTO.removeItem(id);
		List<ItemDTO> listItem = cartDTO.getItems();
		cartDTO.setTotalMoney(cartDTO.getTotalMoney());
		SessionUtill.getInstance().putValue(session, "cart", cartDTO);
		SessionUtill.getInstance().putValue(session, "size", listItem.size());
		SessionUtill.getInstance().putValue(session, "totalProduct", cartDTO.getTotalProduct());
		ModelAndView mav = new ModelAndView("redirect:/Cart");
		mav.addObject("addressDTO", addressDTO);
		return mav;
	}
}
