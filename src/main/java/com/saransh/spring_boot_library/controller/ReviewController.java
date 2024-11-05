package com.saransh.spring_boot_library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.saransh.spring_boot_library.requestmodels.ReviewRequest;
import com.saransh.spring_boot_library.service.ReviewService;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService){
        this.reviewService = reviewService;
    }

    @PostMapping("/secure")
    public void postReview(@RequestBody ReviewRequest reviewRequest){
        String userEmail = "test@gmail.com";
        try {
            reviewService.postReview(userEmail, reviewRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/secure/user/book")
    public Boolean reviewBookByUser(@RequestParam Long bookId){
        String userEmail = "test@gmail.com";
        return reviewService.userReviewListed(userEmail, bookId);
    }
}
