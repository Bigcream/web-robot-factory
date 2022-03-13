package com.blog.dto;

import java.util.ArrayList;
import java.util.List;

public class CartDTO {
	private List<ItemDTO> items;
    private float totalMoney;
    
    private float newTotalMoney;

    public void setTotalMoney(float totalMoney) {
        this.totalMoney = totalMoney;
    }
    
    public CartDTO() {
        items = new ArrayList<>();
    }

    public float getNewTotalMoney() {
		return newTotalMoney;
	}

	public void setNewTotalMoney(float newTotalMoney) {
		this.newTotalMoney = newTotalMoney;
	}

	public List<ItemDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemDTO> items) {
        this.items = items;
    }

    private ItemDTO getItemByID(Long id) {
        for (ItemDTO i : items) {
            if (i.getProductDTO().getId() == id) {
                return i;
            }
        }
        return null;
    }

    public Long getQuantityById(Long id) {

        return getItemByID(id).getQuantity();
    }

    public void addItem(ItemDTO itemDTO) {
        if (getItemByID(itemDTO.getProductDTO().getId()) != null) {
        	ItemDTO item = getItemByID(itemDTO.getProductDTO().getId());
            item.setQuantity(item.getQuantity() + itemDTO.getQuantity());
        } else {
            items.add(itemDTO);
        }
    }

    public void removeItem(Long id) {
        if(getItemByID(id) != null){
            items.remove(getItemByID(id));
        }
    }
    public float getTotalMoney(){
        float totalmoney = 0;
        for(ItemDTO i : items){
            totalmoney += (i.getQuantity()*i.getProductDTO().getPrice());
        }
        return totalmoney;
        
    }
    public int getTotalProduct(){
        int totalProduct = 0;
        for(ItemDTO i : items){
        	totalProduct += (i.getQuantity());
        }
        return totalProduct;
        
    }
}
