package com.blog.api.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.blog.dto.CartDTO;
import com.blog.dto.ItemDTO;
import com.blog.dto.NewDTO;
import com.blog.dto.ProductDTO;
import com.blog.service.IProductService;
import com.blog.util.SessionUtill;

@RestController(value = "cartAPIOfHome")
public class CartAPI {
	@Autowired
	private IProductService productService;
	
	@Autowired
	private SessionUtill sessionUtill;
	@PostMapping("/api/cart")
	public void cartPage(@RequestBody ProductDTO productDTO,HttpSession session) {
		Object object = SessionUtill.getInstance().getValue(session, "cart");
        Long id = productDTO.getId();
        CartDTO cartDTO = null;
        //String Squantity = req.getParameter("sumProductBuy");
       // Long quantity = Long.parseLong(Squantity);
        Long quantity = 1l;
        if (object != null) {
        	cartDTO = (CartDTO) object;
        } else {
        	cartDTO = new CartDTO();
        }
        productDTO = productService.findById(id);
        float price = (float) (productDTO.getPrice());
        ItemDTO itemDTO = new ItemDTO(productDTO, quantity, price);
        cartDTO.addItem(itemDTO);
        List<ItemDTO> listItem = cartDTO.getItems();
        cartDTO.setTotalMoney(cartDTO.getTotalMoney());
        SessionUtill.getInstance().putValue(session, "cart", cartDTO);
        SessionUtill.getInstance().putValue(session, "size", listItem.size());
	}
}
