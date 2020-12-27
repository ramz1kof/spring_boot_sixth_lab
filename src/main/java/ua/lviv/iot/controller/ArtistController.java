package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.model.Artist;
import ua.lviv.iot.service.ArtistService;

import java.util.List;

@RestController
@RequestMapping(value = "/artist")
public class ArtistController {

  @Autowired
  private ArtistService artistService;

  @GetMapping(value = "/{id}")
  public Artist getArtist(@PathVariable("id") Integer artistId) {
    return artistService.getArtistById(artistId);
  }

  @GetMapping
  public List<Artist> getAllArtists() {
    return artistService.getAllArtists();
  }

  @PostMapping
  public Artist addArtist(final @RequestBody Artist artist) {
    return artistService.createArtist(artist);
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<Artist> updateArtist(final @RequestBody Artist artist,
                                             @PathVariable("id") Integer artistId) {
    artist.setId(artistId);
    return artistService.updateArtist(artist, artistId);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Artist> deleteArtist(@PathVariable("id") Integer artistId) {
    return artistService.deleteArtist(artistId);
  }
}
