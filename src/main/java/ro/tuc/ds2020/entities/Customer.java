package ro.tuc.ds2020.entities;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customerId", nullable = false)
    private Long customerId;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "username")
    private User user;

    @Column(name = "date_joined", nullable = false)
    private Date dateJoined;

    @OneToMany(mappedBy = "customer")
    private List<UsedVoucher> usedVoucherList = new ArrayList<>();

    @OneToMany(mappedBy = "customer")
    private List<Cart> cartList = new ArrayList<>();

    @OneToMany(mappedBy = "customer")
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "customer")
    private List<Complaint> complaintList = new ArrayList<>();

    @OneToMany(mappedBy = "customer")
    private List<FavoriteProducts> favoriteProducts = new ArrayList<>();

    public Customer() {}

    public Customer(Long customerId, User user, Date dateJoined) {
        this.customerId = customerId;
        this.user = user;
        this.dateJoined = dateJoined;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(Date dateJoined) {
        this.dateJoined = dateJoined;
    }

    public List<UsedVoucher> getUsedVoucherList() {
        return usedVoucherList;
    }

    public void setUsedVoucherList(List<UsedVoucher> usedVoucherList) {
        this.usedVoucherList = usedVoucherList;
    }

    public List<Cart> getCartList() {
        return cartList;
    }

    public void setCartList(List<Cart> cartList) {
        this.cartList = cartList;
    }

    public List<Review> getReviewList() {
        return reviewList;
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }

    public List<Complaint> getComplaintList() {
        return complaintList;
    }

    public void setComplaintList(List<Complaint> complaintList) {
        this.complaintList = complaintList;
    }

    public List<FavoriteProducts> getFavoriteProducts() {
        return favoriteProducts;
    }

    public void setFavoriteProducts(List<FavoriteProducts> favoriteProducts) {
        this.favoriteProducts = favoriteProducts;
    }
}
