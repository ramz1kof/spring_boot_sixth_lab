package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ua.lviv.iot.dataaccess.ArtistRepository;
import ua.lviv.iot.model.Artist;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ArtistService {

  @Autowired
  private ArtistRepository artistRepository;

  public List<Artist> getAllArtists() {
    return artistRepository.findAll();
  }

  public Artist getArtistById(Integer artistId) {
    if (artistRepository.existsById(artistId)) {
      return artistRepository.findById(artistId).get();
    }
    return null;
  }

  @Transactional
  public Artist createArtist(Artist artist) {
    return artistRepository.save(artist);
  }

  @Transactional
  public ResponseEntity<Artist> deleteArtist(Integer artistId) {
    if (artistRepository.existsById(artistId)) {
      artistRepository.deleteById(artistId);
      return ResponseEntity.ok().build();
    }
    return ResponseEntity.notFound().build();
  }

  @Transactional
  public ResponseEntity<Artist> updateArtist(Artist artist, Integer artistId) {
    if (artistRepository.existsById(artistId)) {
      return ResponseEntity.ok(artistRepository.save(artist));
    }
    return ResponseEntity.notFound().build();
  }
}
