package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ua.lviv.iot.dataaccess.GenreRepository;
import ua.lviv.iot.model.Genre;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class GenreService {

  @Autowired
  private GenreRepository genreRepository;

  public List<Genre> getAllGenres() {
    return genreRepository.findAll();
  }

  public Genre getGenreById(Integer genreId) {
    if (genreRepository.existsById(genreId)) {
      return genreRepository.findById(genreId).get();
    }
    return null;
  }

  @Transactional
  public Genre createGenre(Genre genre) {
    return genreRepository.save(genre);
  }

  @Transactional
  public ResponseEntity<Genre> deleteGenre(Integer genreId) {
    if (genreRepository.existsById(genreId)) {
      genreRepository.deleteById(genreId);
      return ResponseEntity.ok().build();
    }
    return ResponseEntity.notFound().build();
  }

  @Transactional
  public ResponseEntity<Genre> updateGenre(Genre genre, Integer genreId) {
    if (genreRepository.existsById(genreId)) {
      return ResponseEntity.ok(genreRepository.save(genre));
    }
    return ResponseEntity.notFound().build();
  }
}
