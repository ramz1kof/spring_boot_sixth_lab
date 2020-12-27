package ua.lviv.iot.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.model.Artist;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Integer> {
}
