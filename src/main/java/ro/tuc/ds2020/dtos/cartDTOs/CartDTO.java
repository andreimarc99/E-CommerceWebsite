package ro.tuc.ds2020.dtos.cartDTOs;

import ro.tuc.ds2020.dtos.customerDTOs.CustomerDTO;
import ro.tuc.ds2020.dtos.productDTOs.ProductDTO;

import java.util.ArrayList;
import java.util.List;

public class CartDTO {
    private Long cartId;
    private List<ProductDTO> products = new ArrayList<>();
    private CustomerDTO customer;
    private Float fullPrice;

    public CartDTO(Long cartId, List<ProductDTO> products, CustomerDTO customer, Float fullPrice) {
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

    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
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
