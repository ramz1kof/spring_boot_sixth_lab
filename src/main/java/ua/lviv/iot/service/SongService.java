package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ua.lviv.iot.dataaccess.SongRepository;
import ua.lviv.iot.model.Song;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SongService {

  @Autowired
  private SongRepository songRepository;

  public List<Song> getAllSongs() {
    return songRepository.findAll();
  }

  public Song getSongById(Integer songId) {
    if (songRepository.existsById(songId)) {
      return songRepository.findById(songId).get();
    }
    return null;
  }

  @Transactional
  public Song createSong(Song song) {
    return songRepository.save(song);
  }

  @Transactional
  public ResponseEntity<Song> deleteSong(Integer songId) {
    if (songRepository.existsById(songId)) {
      songRepository.deleteById(songId);
      return ResponseEntity.ok().build();
    }
    return ResponseEntity.notFound().build();
  }

  @Transactional
  public ResponseEntity<Song> updateSong(Song song, Integer songId) {
    if (songRepository.existsById(songId)) {
      return ResponseEntity.ok(songRepository.save(song));
    }
    return ResponseEntity.notFound().build();
  }
}
