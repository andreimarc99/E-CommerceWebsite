package ro.tuc.ds2020.dtos._builders;

import ro.tuc.ds2020.dtos.reviewDTOs.ReviewDTO;
import ro.tuc.ds2020.entities.Review;

public class ReviewBuilder {

    public static Review toReview(ReviewDTO reviewDTO) {
        return new Review(reviewDTO.getReviewId(),
                ProductBuilder.toProduct(reviewDTO.getProduct()),
                CustomerBuilder.toCustomer(reviewDTO.getCustomer()),
                reviewDTO.getRating(),
                reviewDTO.getMessage());
    }

    public static ReviewDTO toReviewDTO(Review review) {
        return new ReviewDTO(review.getReviewId(),
                ProductBuilder.toProductDTO(review.getProduct()),
                CustomerBuilder.toCustomerDTO(review.getCustomer()),
                review.getRating(),
                review.getMessage());
    }
}
