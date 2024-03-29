package com.spring.project.moviecatalogservice.resources;

import com.spring.project.moviecatalogservice.models.CatalogItem;
import com.spring.project.moviecatalogservice.models.Movie;
import com.spring.project.moviecatalogservice.models.Rating;
import com.spring.project.moviecatalogservice.models.RatingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId)
    {
        RatingResponse ratings = restTemplate.getForObject("http://movie-ratings-service/ratings/users/" + userId, RatingResponse.class);

        return ratings.getRatings().stream().map(rating -> {
            Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
            return new CatalogItem(movie.getName(), "Desc", rating.getRating());
        }).collect(Collectors.toList());

        /* return Collections.singletonList(
                new CatalogItem("Transformers", "Test", 4)
        );*/
    }
}
