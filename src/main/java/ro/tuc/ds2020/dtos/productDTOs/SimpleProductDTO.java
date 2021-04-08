package ro.tuc.ds2020.dtos.productDTOs;

import ro.tuc.ds2020.entities.Image;

public class SimpleProductDTO {
    private Long productId;
    private String name;
    private Float price;
    private String description;
    private Integer stock;
    private Integer numberSold;

    public SimpleProductDTO() {}

    public SimpleProductDTO(Long productId, String name, Float price, String description, Integer stock,
                      Integer numberSold) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.description = description;
        this.stock = stock;
        this.numberSold = numberSold;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getNumberSold() {
        return numberSold;
    }

    public void setNumberSold(Integer numberSold) {
        this.numberSold = numberSold;
    }
}
