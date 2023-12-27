package org.example.service;

import org.example.entity.Movie;
import org.example.repository.MovieRepo;

public class MovieService {

    private MovieRepo movieRepo;

    public MovieService(MovieRepo movieRepo) {
        this.movieRepo = movieRepo;
    }
    
    public Movie getMovieById(Long id){

        Movie movieById = movieRepo.getById(id);

        return movieById;
    }


}
