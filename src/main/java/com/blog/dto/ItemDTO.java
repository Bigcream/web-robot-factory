package com.blog.dto;

public class ItemDTO {
    private ProductDTO productDTO;
    private Long quantity;
    private float price;

    public ItemDTO() {
    }

    public ItemDTO(ProductDTO productDTO, Long quantity, float price) {
        this.productDTO = productDTO;
        this.quantity = quantity;
        this.price = price;
    }

    public ProductDTO getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
}
