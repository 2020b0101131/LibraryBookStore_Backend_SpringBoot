package com.saransh.spring_boot_library.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.saransh.spring_boot_library.dao.BookRepository;
import com.saransh.spring_boot_library.dao.ReviewRepository;
import com.saransh.spring_boot_library.entity.Review;
import com.saransh.spring_boot_library.requestmodels.ReviewRequest;

@Service
@Transactional
public class ReviewService {

    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public void postReview(String userEmail, ReviewRequest reviewRequest) throws Exception {
        // Check if the review already exists
        Optional<Review> existingReview = reviewRepository.findByUserEmailAndBookId(userEmail, reviewRequest.getBookId());
        if (existingReview.isPresent()) {
            throw new Exception("Review Already Created");
        }

        // Create a new review
        Review review = new Review();
        review.setBookId(reviewRequest.getBookId());
        review.setRating(reviewRequest.getRating());
        review.setUserEmail(userEmail);
        review.setReviewDescription(reviewRequest.getReviewDescription().orElse(null));
        review.setDate(Date.valueOf(LocalDate.now()));
        
        // Save the review
        reviewRepository.save(review);
    }

    public Boolean userReviewListed(String userEmail, Long bookId) {
        return reviewRepository.findByUserEmailAndBookId(userEmail, bookId).isPresent();
    }
}
