package ro.tuc.ds2020.dtos.favoriteProductsDTOs;

import ro.tuc.ds2020.dtos.customerDTOs.CustomerDTO;
import ro.tuc.ds2020.dtos.productDTOs.ProductDTO;
import ro.tuc.ds2020.dtos.productDTOs.ProductWithImageDTO;
import ro.tuc.ds2020.entities.Customer;

import java.util.ArrayList;
import java.util.List;

public class FavoriteProductsDTO {

    private Long favoriteProductsId;
    private CustomerDTO customer;
    private List<ProductWithImageDTO> products = new ArrayList<>();

    public FavoriteProductsDTO(Long favoriteProductsId, CustomerDTO customer, List<ProductWithImageDTO> products) {
        this.favoriteProductsId = favoriteProductsId;
        this.customer = customer;
        this.products = products;
    }

    public Long getFavoriteProductsId() {
        return favoriteProductsId;
    }

    public void setFavoriteProductsId(Long favoriteProductsId) {
        this.favoriteProductsId = favoriteProductsId;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public List<ProductWithImageDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductWithImageDTO> products) {
        this.products = products;
    }
}
