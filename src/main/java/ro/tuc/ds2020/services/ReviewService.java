package ro.tuc.ds2020.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.dtos._builders.ReviewBuilder;
import ro.tuc.ds2020.dtos.reviewDTOs.ReviewDTO;
import ro.tuc.ds2020.entities.Review;
import ro.tuc.ds2020.repositories.ReviewRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReviewService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReviewService.class);
    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<ReviewDTO> findReviews() {
        List<Review> reviews = reviewRepository.findAll();
        return reviews.stream()
                .map(ReviewBuilder::toReviewDTO)
                .collect(Collectors.toList());
    }

    public List<ReviewDTO> getReviewsByProductId(Long productId) {
        List<Review> reviews = reviewRepository.getReviewByProductId(productId);
        return reviews.stream()
                .map(ReviewBuilder::toReviewDTO)
                .collect(Collectors.toList());
    }

    public Long insertReview(ReviewDTO reviewDTO) {
        Review review = ReviewBuilder.toReview(reviewDTO);
        review = reviewRepository.save(review);
        LOGGER.debug("Review with ID {} was inserted in db", review.getReviewId());
        return review.getReviewId();
    }

    public void deleteReview(Long reviewId) throws ResourceNotFoundException {
        Optional<Review> review = reviewRepository.findById(reviewId);
        if (!review.isPresent()) {
            throw new ResourceNotFoundException("Review with id " + reviewId + " not found.");
        }
        reviewRepository.deleteById(reviewId);
    }

    public ReviewDTO updateReview(ReviewDTO reviewDTO) throws ResourceNotFoundException {
        Optional<Review> review = reviewRepository.findById(reviewDTO.getReviewId());
        if (!review.isPresent()) {
            throw new ResourceNotFoundException("Review with ID " + reviewDTO.getReviewId() + " not found.");
        }
        Review updatedReview = ReviewBuilder.toReview(reviewDTO);
        ReviewDTO updatedReviewDTO = ReviewBuilder.toReviewDTO(reviewRepository.save(updatedReview));
        return updatedReviewDTO;
    }
}
