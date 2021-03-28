package ro.tuc.ds2020.dtos.reviewDTOs;

import ro.tuc.ds2020.dtos.customerDTOs.CustomerDTO;
import ro.tuc.ds2020.dtos.productDTOs.ProductDTO;

public class ReviewDTO {
    private Long reviewId;
    private ProductDTO product;
    private CustomerDTO customer;
    private Integer rating;
    private String message;

    public ReviewDTO() {}

    public ReviewDTO(Long reviewId, ProductDTO product, CustomerDTO customer, Integer rating, String message) {
        this.reviewId = reviewId;
        this.product = product;
        this.customer = customer;
        this.rating = rating;
        this.message = message;
    }

    public Long getReviewId() {
        return reviewId;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
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