package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.model.Genre;
import ua.lviv.iot.service.GenreService;

import java.util.List;

@RestController
@RequestMapping(value = "/genre")
public class GenreController {

  @Autowired
  private GenreService genreService;

  @GetMapping(value = "/{id}")
  public Genre getGenre(@PathVariable("id") Integer genreId) {
    return genreService.getGenreById(genreId);
  }

  @GetMapping
  public List<Genre> getAllGenres() {
    return genreService.getAllGenres();
  }

  @PostMapping
  public Genre addGenre(final @RequestBody Genre genre) {
    return genreService.createGenre(genre);
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<Genre> updateGenre(final @RequestBody Genre genre,
                                           @PathVariable("id") Integer genreId) {
    genre.setId(genreId);
    return genreService.updateGenre(genre, genreId);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Genre> deleteGenre(@PathVariable("id") Integer genreId) {
    return genreService.deleteGenre(genreId);
  }
}
