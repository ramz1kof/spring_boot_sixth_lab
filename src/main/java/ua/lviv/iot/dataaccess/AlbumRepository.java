package ua.lviv.iot.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.iot.model.Album;

public interface AlbumRepository extends JpaRepository<Album, Integer> {
}
