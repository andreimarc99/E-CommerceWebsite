package ro.tuc.ds2020.dtos.favoriteProductsDTOs;

import ro.tuc.ds2020.dtos.customerDTOs.CustomerDTO;
import ro.tuc.ds2020.entities.Customer;

import java.util.List;

public class ShortFavoriteProductsDTO {
    private Long favoriteProductsId;
    private CustomerDTO customer;

    public ShortFavoriteProductsDTO(Long favoriteProductsId, CustomerDTO customer) {
        this.favoriteProductsId = favoriteProductsId;
        this.customer = customer;
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
}
