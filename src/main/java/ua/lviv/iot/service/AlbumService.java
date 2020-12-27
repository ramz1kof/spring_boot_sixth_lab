package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ua.lviv.iot.dataaccess.AlbumRepository;
import ua.lviv.iot.model.Album;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AlbumService {

  @Autowired
  private AlbumRepository albumRepository;

  public List<Album> getAllAlbums() {
    return albumRepository.findAll();
  }

  public Album getAlbumById(Integer albumId) {
    if (albumRepository.existsById(albumId)) {
      return albumRepository.findById(albumId).get();
    }
    return null;
  }

  @Transactional
  public Album createAlbum(Album album) {
    return albumRepository.save(album);
  }

  @Transactional
  public ResponseEntity<Album> deleteAlbum(Integer albumId) {
    if (albumRepository.existsById(albumId)) {
      albumRepository.deleteById(albumId);
      return ResponseEntity.ok().build();
    }
    return ResponseEntity.notFound().build();
  }

  @Transactional
  public ResponseEntity<Album> updateAlbum(Album album, Integer albumId) {
    if (albumRepository.existsById(albumId)) {
      return ResponseEntity.ok(albumRepository.save(album));
    }
    return ResponseEntity.notFound().build();
  }
}
