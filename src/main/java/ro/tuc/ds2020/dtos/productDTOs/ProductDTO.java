package ro.tuc.ds2020.dtos.productDTOs;

import ro.tuc.ds2020.entities.Specs;

public class ProductDTO {
    private Long productId;
    private Specs specs;
    private String name;
    private Float price;
    private String description;
    private Integer stock;

    public ProductDTO() {}

    public ProductDTO(Long productId, Specs specs, String name, Float price, String description, Integer stock) {
        this.productId = productId;
        this.specs = specs;
        this.name = name;
        this.price = price;
        this.description = description;
        this.stock = stock;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Specs getSpecs() {
        return specs;
    }

    public void setSpecs(Specs specs) {
        this.specs = specs;
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
}
