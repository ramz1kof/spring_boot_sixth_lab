package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.model.Album;
import ua.lviv.iot.service.AlbumService;

import java.util.List;

@RestController
@RequestMapping(value = "/album")
public class AlbumController {

  @Autowired
  private AlbumService albumService;

  @GetMapping(value = "/{id}")
  public Album getAlbum(@PathVariable("id") Integer albumId) {
    return albumService.getAlbumById(albumId);
  }

  @GetMapping
  public List<Album> getAllAlbums() {
    return albumService.getAllAlbums();
  }

  @PostMapping
  public Album addAlbum(final @RequestBody Album album) {
    return albumService.createAlbum(album);
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<Album> updateAlbum(final @RequestBody Album album,
                                           @PathVariable("id") Integer albumId) {
    album.setId(albumId);
    return albumService.updateAlbum(album, albumId);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Album> deleteAlbum(@PathVariable("id") Integer albumId) {
    return albumService.deleteAlbum(albumId);
  }
}
