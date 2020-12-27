package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ua.lviv.iot.dataaccess.MusicVideoRepository;
import ua.lviv.iot.model.MusicVideo;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MusicVideoService {

  @Autowired
  private MusicVideoRepository musicVideoRepository;

  public List<MusicVideo> getAllMusicVideos() {
    return musicVideoRepository.findAll();
  }

  public MusicVideo getMusicVideoById(Integer musicVideoId) {
    if (musicVideoRepository.existsById(musicVideoId)) {
      return musicVideoRepository.findById(musicVideoId).get();
    }
    return null;
  }

  @Transactional
  public MusicVideo createMusicVideo(MusicVideo musicVideo) {
    return musicVideoRepository.save(musicVideo);
  }

  @Transactional
  public ResponseEntity<MusicVideo> deleteMusicVideo(Integer musicVideoId) {
    if (musicVideoRepository.existsById(musicVideoId)) {
      musicVideoRepository.deleteById(musicVideoId);
      return ResponseEntity.ok().build();
    }
    return ResponseEntity.notFound().build();
  }

  @Transactional
  public ResponseEntity<MusicVideo> updateMusicVideo(MusicVideo musicVideo, Integer musicVideoId) {
    if (musicVideoRepository.existsById(musicVideoId)) {
      return ResponseEntity.ok(musicVideoRepository.save(musicVideo));
    }
    return ResponseEntity.notFound().build();
  }
}
