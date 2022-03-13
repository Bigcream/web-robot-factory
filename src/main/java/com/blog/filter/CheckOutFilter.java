package com.blog.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import com.blog.dto.MyUser;
import com.blog.util.SecurityUtils;
import com.blog.util.SessionUtill;

/**
 *
 * @author ASUS
 */
public class CheckOutFilter implements Filter {

	@Autowired
	private SessionUtill sessionUtill;
    private ServletContext context;
    private HttpSession session;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.context = filterConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        StringBuilder url = new StringBuilder();
        url.append(req.getRequestURI());
        
        if (url.toString().startsWith("/Check-out")) {
        	Long check = (Long) SessionUtill.getInstance().getValue(req, "check");
            if (check != null ) {
            	chain.doFilter(request, response);
            } else {
            	resp.sendRedirect(req.getContextPath() + "/Login");
            }
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}