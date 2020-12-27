package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.model.MusicVideo;
import ua.lviv.iot.service.MusicVideoService;

import java.util.List;

@RestController
@RequestMapping(value = "/music_video")
public class MusicVideoController {

  @Autowired
  private MusicVideoService musicVideoService;

  @GetMapping(value = "/{id}")
  public MusicVideo getMusicVideo(@PathVariable("id") Integer musicVideoId) {
    return musicVideoService.getMusicVideoById(musicVideoId);
  }

  @GetMapping
  public List<MusicVideo> getAllMusicVideos() {
    return musicVideoService.getAllMusicVideos();
  }

  @PostMapping
  public MusicVideo addMusicVideo(final @RequestBody MusicVideo musicVideo) {
    return musicVideoService.createMusicVideo(musicVideo);
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<MusicVideo> updateMusicVideo(final @RequestBody MusicVideo musicVideo,
                                                     @PathVariable("id") Integer musicVideoId) {
    musicVideo.setId(musicVideoId);
    return musicVideoService.updateMusicVideo(musicVideo, musicVideoId);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<MusicVideo> deleteMusicVideo(@PathVariable("id") Integer musicVideoId) {
    return musicVideoService.deleteMusicVideo(musicVideoId);
  }
}
