package ua.lviv.iot.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.iot.model.RecordLabel;

public interface RecordLabelRepository extends JpaRepository<RecordLabel, Integer> {
}
