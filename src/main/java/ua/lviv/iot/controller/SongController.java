package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.model.Song;
import ua.lviv.iot.service.SongService;

import java.util.List;

@RestController
@RequestMapping(value = "/song")
public class SongController {

  @Autowired
  private SongService songService;

  @GetMapping(value = "/{id}")
  public Song getSong(@PathVariable("id") Integer songId) {
    return songService.getSongById(songId);
  }

  @GetMapping
  public List<Song> getAllSongs() {
    return songService.getAllSongs();
  }

  @PostMapping
  public Song addSong(final @RequestBody Song song) {
    return songService.createSong(song);
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<Song> updateSong(final @RequestBody Song song,
                                         @PathVariable("id") Integer songId) {
    song.setId(songId);
    return songService.updateSong(song, songId);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Song> deleteSong(@PathVariable("id") Integer songId) {
    return songService.deleteSong(songId);
  }
}
