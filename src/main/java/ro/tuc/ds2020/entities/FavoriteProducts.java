package ro.tuc.ds2020.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "favorite_products")
public class FavoriteProducts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "favoriteProductsId", nullable = false)
    private Long favoriteProductsId;

    @ManyToOne()
    @JoinColumn(name = "customerId")
    private Customer customer;

    @ManyToMany ()
    @JoinTable(
            name = "favProducts_product",
            joinColumns = @JoinColumn(name = "favoriteProductsId"),
            inverseJoinColumns = @JoinColumn(name = "productId")
    )
    private List<Product> products = new ArrayList<>();

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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
