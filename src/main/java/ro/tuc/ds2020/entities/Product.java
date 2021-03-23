package ro.tuc.ds2020.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productId", nullable = false)
    private Long productId;

    @ManyToMany(mappedBy = "products")
    private List<Cart> cartList = new ArrayList<>();

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "specsId")
    private Specs specs;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private Float price;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "stock", nullable = false)
    private Integer stock;

    @OneToMany(mappedBy = "product")
    private List<Review> reviewList = new ArrayList<>();

    @ManyToMany(mappedBy = "products")
    private List<FavoriteProducts> favoriteProductsList = new ArrayList<>();

    public Product() {}

    public Product(Long productId, Specs specs, String name, Float price, String description, Integer stock) {
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

    public List<Cart> getCartList() {
        return cartList;
    }

    public void setCartList(List<Cart> cartList) {
        this.cartList = cartList;
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

    public List<Review> getReviewList() {
        return reviewList;
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }

    public List<FavoriteProducts> getFavoriteProductsList() {
        return favoriteProductsList;
    }

    public void setFavoriteProductsList(List<FavoriteProducts> favoriteProductsList) {
        this.favoriteProductsList = favoriteProductsList;
    }
}
