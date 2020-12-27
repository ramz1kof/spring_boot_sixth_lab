package ua.lviv.iot.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.iot.model.MusicVideo;

public interface MusicVideoRepository extends JpaRepository<MusicVideo, Integer> {
}
