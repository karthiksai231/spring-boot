package com.spring.project.moviedataservice.resources;

import com.spring.project.moviedataservice.models.Rating;
import com.spring.project.moviedataservice.models.RatingResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingsResource {

    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId) {
        return new Rating(movieId, 4);
    }

    @RequestMapping("users/{userId}")
    public RatingResponse getUserRating(@PathVariable("userId") String userId) {
        List<Rating> ratings = Arrays.asList(
                new Rating("123", 4),
                new Rating("456", 5)
        );

        return new RatingResponse(ratings);
    }
}
