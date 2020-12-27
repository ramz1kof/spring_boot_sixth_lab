package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ua.lviv.iot.dataaccess.RecordLabelRepository;
import ua.lviv.iot.model.RecordLabel;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RecordLabelService {

  @Autowired
  private RecordLabelRepository recordLabelRepository;

  public List<RecordLabel> getAllRecordLabels() {
    return recordLabelRepository.findAll();
  }

  public RecordLabel getRecordLabelById(Integer recordLabelId) {
    if (recordLabelRepository.existsById(recordLabelId)) {
      return recordLabelRepository.findById(recordLabelId).get();
    }
    return null;
  }

  @Transactional
  public RecordLabel createRecordLabel(RecordLabel recordLabel) {
    return recordLabelRepository.save(recordLabel);
  }

  @Transactional
  public ResponseEntity<RecordLabel> deleteRecordLabel(Integer recordLabelId) {
    if (recordLabelRepository.existsById(recordLabelId)) {
      recordLabelRepository.deleteById(recordLabelId);
      return ResponseEntity.ok().build();
    }
    return ResponseEntity.notFound().build();
  }

  @Transactional
  public ResponseEntity<RecordLabel> updateRecordLabel(RecordLabel recordLabel, Integer recordLabelId) {
    if (recordLabelRepository.existsById(recordLabelId)) {
      return ResponseEntity.ok(recordLabelRepository.save(recordLabel));
    }
    return ResponseEntity.notFound().build();
  }
}
