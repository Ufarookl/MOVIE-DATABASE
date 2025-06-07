package com.umar.MoviesDataBase.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieDTO {
    private Long id;
    private String title;
    private String genre;
    private String language;
    private String director;
    private int releaseYear;
    private int durationMinutes;
    private String description;
}