package com.umar.MoviesDataBase.Mapper;

import com.umar.MoviesDataBase.dto.MovieDTO;
import com.umar.MoviesDataBase.model.Movie;

public class MovieMapper {

    public static MovieDTO toDto(Movie movie){
        return MovieDTO.builder()
                .id(movie.getId())
                .title((movie.getTitle()))
                .description((movie.getDescription()))
                .genre((movie.getGenre()))
                .director((movie.getDirector()))
                .language((movie.getLanguage()))
                .releaseYear(movie.getReleaseYear())
                .durationMinutes(movie.getDurationMinutes())
                .build();
    }

    public static Movie toEntity(MovieDTO movieDTO){
        return Movie.builder()
                .id(movieDTO.getId())
                .title(movieDTO.getTitle())
                .language(movieDTO.getLanguage())
                .genre(movieDTO.getGenre())
                .director(movieDTO.getDirector())
                .durationMinutes(movieDTO.getDurationMinutes())
                .releaseYear(movieDTO.getReleaseYear())
                .description(movieDTO.getDescription())
                .build();
    }
}
