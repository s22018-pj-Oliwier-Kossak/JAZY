package com.example.movies;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MovieService {
 private final MovieRepo movieRepo;
 MovieService(MovieRepo movieRepo){
     this.movieRepo=movieRepo;
 }

     public List<MovieEntity> GetAllmovies(){

         return movieRepo.findAll();
     }



     public MovieEntity getID(Long id){

         if (movieRepo.findById(id).get()==null){

             throw new RuntimeException();
         }
         return movieRepo.findById(id).get();
     }

     public MovieEntity postMethod(MovieEntity movieEntity){
         if(movieEntity.getNazwa()==null || movieEntity.getKategoria()==null){
             throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
         }
         return movieRepo.save(movieEntity);
     }
     public MovieEntity putMethod(Long id, MovieEntity movieEntity){
        MovieEntity updateMovie =movieRepo.findById(id).get();
        updateMovie.setNazwa(movieEntity.getNazwa());
        updateMovie.setKategoria(movieEntity.getKategoria());
        updateMovie.setBudzet(movieEntity.getBudzet());
        return movieRepo.save(updateMovie);
     }



     public void deleteMovie (Long id){
     MovieEntity deleteMovie=movieRepo.findById(id).get();
        movieRepo.delete(deleteMovie);
     }

     public MovieEntity avabile(Long id){
         MovieEntity updateMovie =movieRepo.findById(id).get();
         updateMovie.setAvaible(true);
         return movieRepo.save(updateMovie);

     }

    public MovieEntity avabileFalse(Long id){
        MovieEntity updateMovie =movieRepo.findById(id).get();
        updateMovie.setAvaible(false);
        return movieRepo.save(updateMovie);

    }



//     public List<MovieEntity> allMoviesDelete(){
//      return movieRepo.delete(movieRepo.findAll());
//     }



}
