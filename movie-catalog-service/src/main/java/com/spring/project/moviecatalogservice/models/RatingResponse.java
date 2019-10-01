package com.spring.project.moviecatalogservice.models;

import java.util.List;

public class RatingResponse {
    private List<Rating> ratings;

    public RatingResponse() {}

    public RatingResponse(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }
}
