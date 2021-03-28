package ro.tuc.ds2020.dtos.favoriteProductsDTOs;

import ro.tuc.ds2020.entities.Customer;

public class ShortFavoriteProductsDTO {
    private Long favoriteProductsId;
    private Customer customer;

    public ShortFavoriteProductsDTO(Long favoriteProductsId, Customer customer) {
        this.favoriteProductsId = favoriteProductsId;
        this.customer = customer;
    }

    public Long getFavoriteProductsId() {
        return favoriteProductsId;
    }

    public void setFavoriteProductsId(Long favoriteProductsId) {
        this.favoriteProductsId = favoriteProductsId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
