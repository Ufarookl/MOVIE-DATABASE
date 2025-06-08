package com.umar.MoviesDataBase.service;

import com.umar.MoviesDataBase.exception.ResourceNotFoundException;
import com.umar.MoviesDataBase.model.Movie;
import com.umar.MoviesDataBase.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie getMovieById(Long id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found with id: " + id));
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public List<Movie> getMoviesByGenre(String genre) {
        return movieRepository.findByGenre(genre);
    }

    @Override
    public List<Movie> getMoviesByLanguage(String language) {
        return movieRepository.findByLanguage(language);
    }

    @Override
    public List<Movie> getMoviesByTitle(String title) {
        return (List<Movie>) movieRepository.findByTitle(title);
    }

    @Override
    public Movie updateMovie(Long id, Movie movie) {
        Movie existingMovie = getMovieById(id);

        movie.setId(existingMovie.getId());
//        existingMovie.setTitle(movie.getTitle());
//        existingMovie.setGenre(movie.getGenre());
//        existingMovie.setLanguage(movie.getLanguage());
//        existingMovie.setDirector(movie.getDirector());
//        existingMovie.setDescription(movie.getDescription());
//        existingMovie.setDurationMinutes(movie.getDurationMinutes());
//        existingMovie.setDurationMinutes(movie.getDurationMinutes());
        return movieRepository.save(movie);
    }

    @Override
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);

    }

    @Override
    public Page<Movie> getMoviesPaginated(Pageable pageable) {
        return movieRepository.findAll(pageable);
    }

    @Override
    public List<Movie> getMoviesByGenreandLanguage(String genre, String language) {
        return movieRepository.findByGenreAndLanguage(genre, language);
    }
}
