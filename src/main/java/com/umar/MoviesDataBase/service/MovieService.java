package com.umar.MoviesDataBase.service;

import com.umar.MoviesDataBase.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


public interface MovieService {
    Movie addMovie(Movie movie);
    Movie getMovieById(Long id);
    List<Movie> getAllMovies();
    List<Movie> getMoviesByGenre(String genre);
    List<Movie> getMoviesByLanguage(String language);
    List<Movie> getMoviesByTitle(String title);
    Movie updateMovie(Long id, Movie movie);
    void deleteMovie(Long id);
    Page<Movie> getMoviesPaginated(Pageable pageable);
}
