package ro.tuc.ds2020.entities;

import javax.persistence.*;

@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reviewId", nullable = false)
    private Long reviewId;

    @ManyToOne()
    @JoinColumn(name = "productId")
    private Product product;

    @ManyToOne()
    @JoinColumn(name = "customerId")
    private Customer customer;

    @Column(name = "rating", nullable = false)
    private Integer rating;

    @Column(name = "message", nullable = false)
    private String message;

    public Long getReviewId() {
        return reviewId;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
