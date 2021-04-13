package ro.tuc.ds2020.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.dtos.reviewDTOs.ReviewDTO;
import ro.tuc.ds2020.services.ReviewService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping()
    public ResponseEntity<List<ReviewDTO>> findAll() {
        List<ReviewDTO> reviewDTOS = reviewService.findReviews();
        return new ResponseEntity<>(reviewDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "/{productId}")
    public ResponseEntity<List<ReviewDTO>> getReviewsByProductId(@PathVariable Long productId) {
        List<ReviewDTO> reviewDTOS = reviewService.getReviewsByProductId(productId);
        return new ResponseEntity<>(reviewDTOS, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Long> insertReview(@RequestBody ReviewDTO reviewDTO) {
        Long insertedReviewId;
        try {
            insertedReviewId = reviewService.insertReview(reviewDTO);
            return new ResponseEntity<>(insertedReviewId, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/{reviewId}")
    public ResponseEntity<Long> deleteReview(@PathVariable Long reviewId) {
        try {
            reviewService.deleteReview(reviewId);
            return new ResponseEntity<>(reviewId, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(reviewId, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping()
    public ResponseEntity<Long> updateReview(@RequestBody ReviewDTO reviewDTO) {
        try {
            reviewService.updateReview(reviewDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
