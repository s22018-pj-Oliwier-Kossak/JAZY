package com.example.movies;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/")
public class RestController {
    private final MovieService movieService;
    RestController(MovieService movieService){this.movieService=movieService;}

    @GetMapping("/movies")
    public ResponseEntity<List<MovieEntity>> GetMovies(){
        List<MovieEntity> movies =movieService.GetAllmovies();
        return ResponseEntity.ok(movies);
    }
    @GetMapping("/movies/{id}")
    public ResponseEntity<MovieEntity> GetMovies(@PathVariable Long id){

        return ResponseEntity.ok(movieService.getID(id));
    }

    @GetMapping("/moviesAvailable/{id}")
    public ResponseEntity<MovieEntity> MoviesAvailable(@PathVariable Long id){

        return ResponseEntity.ok(movieService.avabile(id));
    }

    @GetMapping("/moviesFalse/{id}")
    public ResponseEntity<MovieEntity> MoviesFalse(@PathVariable Long id){

        return ResponseEntity.ok(movieService.avabileFalse(id));
    }


    @PostMapping(value="/save")
    public MovieEntity saveMovie(@RequestBody MovieEntity movieEntity){
        return movieService.postMethod(movieEntity);
    }

    @PutMapping("/movie/{id}")
    public MovieEntity updateMovie(@PathVariable Long id, @RequestBody MovieEntity movieEntity){
        return movieService.putMethod(id, movieEntity);
    }

    @DeleteMapping("movies/{id}")
    public String deleteMovie(@PathVariable Long id){
         movieService.deleteMovie(id);
         return "delete "+id;
    }




}
