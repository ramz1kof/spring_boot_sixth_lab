package ua.lviv.iot.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.iot.model.Song;

public interface SongRepository extends JpaRepository<Song, Integer> {
}
