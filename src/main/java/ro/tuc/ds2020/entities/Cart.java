package ro.tuc.ds2020.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cartId", nullable = false)
    private Long cartId;

    @ManyToMany ()
    @JoinTable(
            name = "cart_product",
            joinColumns = @JoinColumn(name = "cartId"),
            inverseJoinColumns = @JoinColumn(name = "productId")
    )
    private List<Product> products = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customerId")
    private Customer customer;

    @Column(name = "fullPrice", nullable = false)
    private Float fullPrice;

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Float getFullPrice() {
        return fullPrice;
    }

    public void setFullPrice(Float fullPrice) {
        this.fullPrice = fullPrice;
    }
}
