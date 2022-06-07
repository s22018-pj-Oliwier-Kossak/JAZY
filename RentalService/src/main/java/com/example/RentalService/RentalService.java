package com.example.RentalService;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

@Service
public class RentalService {
    private final RestTemplate restTemplate;

    RentalService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getMovies() {

        ResponseEntity<String> exchange = restTemplate.exchange("http://localhost:8080/movies",
                HttpMethod.GET,
                HttpEntity.EMPTY,
                String.class);
        return exchange.getBody();
    }

    public Movie getMovie(Long id) {
        Movie exchange = restTemplate.getForEntity("http://localhost:8080/movies/" + id, Movie.class).getBody();
        return exchange;

//        ResponseEntity<Movie> exchange = restTemplate.exchange("http://localhost:8080/movies/"+id,
//                HttpMethod.GET,
//                HttpEntity.EMPTY,
//                Movie.class);
//        return exchange.getBody();
    }

    public Movie returnMovie(Long id) {
        Movie exchange = restTemplate.getForEntity("http://localhost:8080/moviesAvailable/" + id, Movie.class).getBody();
        return exchange;
    }
    public Movie returnFalseMovie(Long id) {
        Movie exchange = restTemplate.getForEntity("http://localhost:8080/moviesFalse/" + id, Movie.class).getBody();
        return exchange;
    }
}
