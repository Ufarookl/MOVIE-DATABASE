package com.umar.MoviesDataBase.controller;

import com.umar.MoviesDataBase.dto.MovieDTO;
import com.umar.MoviesDataBase.model.Movie;
import com.umar.MoviesDataBase.Mapper.MovieMapper;
import com.umar.MoviesDataBase.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public List<MovieDTO> getAll() {
        return movieService.getAllMovies().stream().map(MovieMapper::toDto).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<MovieDTO> addMovie(@RequestBody MovieDTO movieDTO) {
        Movie movie = movieService.addMovie(MovieMapper.toEntity(movieDTO));
        return ResponseEntity
                .status(201) // Set HTTP 201 Created
                .body(MovieMapper.toDto(movie));
    }

    @GetMapping("movie/{id}")
    public ResponseEntity<MovieDTO> getMovieById(@PathVariable Long id) {
        Movie movie = movieService.getMovieById(id);
        return ResponseEntity.status(200).body(MovieMapper.toDto(movie));
    }

    @GetMapping("movie/{title}")
    public List<MovieDTO> getMovieByTitle(@PathVariable String title) {
        return movieService.getMoviesByTitle(title).stream().map(MovieMapper::toDto).collect(Collectors.toList());
    }
    @GetMapping("/genre/{genre}")
    public List<MovieDTO> getByGenre(@PathVariable String genre) {
        return movieService.getMoviesByGenre(genre).stream().map(MovieMapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/language/{language}")
    public List<MovieDTO> getByLanguage(@PathVariable String language) {
        return movieService.getMoviesByLanguage(language).stream().map(MovieMapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("search")
    public List<MovieDTO> search(@RequestParam String genre, @RequestParam String language) {
        return movieService.getMoviesByGenreandLanguage(genre, language).stream().map(MovieMapper::toDto).collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieDTO> update(@PathVariable Long id, @RequestBody MovieDTO dto) {
        Movie updated = movieService.updateMovie(id, MovieMapper.toEntity(dto));
        return ResponseEntity.ok(MovieMapper.toDto(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        movieService.deleteMovie(id);
        return ResponseEntity.ok("Deleted movie with ID: " + id);
    }
    //PAginated api
    @GetMapping("/paginated")
    public ResponseEntity<Page<MovieDTO>> getPaginated(@RequestParam(defaultValue = "0") int page,
                                                       @RequestParam(defaultValue = "5") int size,
                                                       @RequestParam(defaultValue = "id") String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        Page<MovieDTO> dtoPage = movieService.getMoviesPaginated(pageable).map(MovieMapper::toDto);
        return ResponseEntity.ok(dtoPage);
    }

}
