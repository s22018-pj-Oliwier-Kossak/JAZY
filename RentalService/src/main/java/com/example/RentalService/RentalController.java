package com.example.RentalService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class RentalController {
    private final RentalService rentalService;
    RentalController(RentalService rentalService){
        this.rentalService=rentalService;
    }
    @GetMapping("/call")
    public String callMovies(){
        return rentalService.getMovies();
    }

    @GetMapping("/movies/{id}")
    public Movie callMovie(@PathVariable Long id){
        return rentalService.getMovie(id);
    }
    @GetMapping("/movies2/{id}")
    public Movie restMovie(@PathVariable Long id){
        return rentalService.returnMovie(id);
    }

    @GetMapping("/moviesFalse/{id}")
    public Movie restFalseMovie(@PathVariable Long id){
        return rentalService.returnFalseMovie(id);
    }

}
