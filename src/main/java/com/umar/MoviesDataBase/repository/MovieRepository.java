package com.umar.MoviesDataBase.repository;

import com.umar.MoviesDataBase.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository  extends JpaRepository<Movie, Long> {
    List<Movie> findByGenre(String genre);
    List<Movie> findByLanguage(String language);
    Page<Movie> findAll(Pageable pageable);
    Movie findByTitle(String title);
    @Query(value = "Select * from movies Where genre=:genre and language= :language", nativeQuery = true)
    List<Movie> findByGenreAndLanguage(@Param("genre") String genre,@Param("language") String language);
}
