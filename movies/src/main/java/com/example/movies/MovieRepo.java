package com.example.movies;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepo extends JpaRepository<MovieEntity,Long> {

}
