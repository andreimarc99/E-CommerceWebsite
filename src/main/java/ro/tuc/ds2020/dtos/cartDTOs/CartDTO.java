package ro.tuc.ds2020.dtos.cartDTOs;

import ro.tuc.ds2020.dtos.customerDTOs.CustomerDTO;
import ro.tuc.ds2020.dtos.productDTOs.ProductDTO;
import ro.tuc.ds2020.dtos.productDTOs.ProductWithImageDTO;

import java.util.ArrayList;
import java.util.List;

public class CartDTO {
    private Long cartId;
    private List<ProductWithImageDTO> products = new ArrayList<>();
    private CustomerDTO customer;
    private Float fullPrice;

    public CartDTO(Long cartId, List<ProductWithImageDTO> products, CustomerDTO customer, Float fullPrice) {
        this.cartId = cartId;
        this.products = products;
        this.customer = customer;
        this.fullPrice = fullPrice;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public List<ProductWithImageDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductWithImageDTO> products) {
        this.products = products;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public Float getFullPrice() {
        return fullPrice;
    }

    public void setFullPrice(Float fullPrice) {
        this.fullPrice = fullPrice;
    }
}
