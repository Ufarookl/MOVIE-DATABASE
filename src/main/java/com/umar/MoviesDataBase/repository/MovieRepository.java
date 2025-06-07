package com.umar.MoviesDataBase.repository;

import com.umar.MoviesDataBase.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository  extends JpaRepository<Movie, Long> {
    List<Movie> findByGenre(String genre);
    List<Movie> findByLanguage(String language);
    Page<Movie> findAll(Pageable pageable);
    Movie findByTitle(String title);
}
