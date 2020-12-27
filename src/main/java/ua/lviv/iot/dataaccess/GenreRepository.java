package ua.lviv.iot.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.iot.model.Genre;

public interface GenreRepository extends JpaRepository<Genre, Integer> {
}
