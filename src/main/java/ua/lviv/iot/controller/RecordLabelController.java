package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.model.RecordLabel;
import ua.lviv.iot.service.RecordLabelService;

import java.util.List;

@RestController
@RequestMapping(value = "/record_label")
public class RecordLabelController {

  @Autowired
  private RecordLabelService recordLabelService;

  @GetMapping(value = "/{id}")
  public RecordLabel getRecordLabel(@PathVariable("id") Integer recordLabelId) {
    return recordLabelService.getRecordLabelById(recordLabelId);
  }

  @GetMapping
  public List<RecordLabel> getAllRecordLabels() {
    return recordLabelService.getAllRecordLabels();
  }

  @PostMapping
  public RecordLabel addRecordLabel(final @RequestBody RecordLabel recordLabel) {
    return recordLabelService.createRecordLabel(recordLabel);
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<RecordLabel> updateRecordLabel(final @RequestBody RecordLabel recordLabel,
                                                       @PathVariable("id") Integer recordLabelId) {
    recordLabel.setId(recordLabelId);
    return recordLabelService.updateRecordLabel(recordLabel, recordLabelId);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<RecordLabel> deleteRecordLabel(@PathVariable("id") Integer recordLabelId) {
    return recordLabelService.deleteRecordLabel(recordLabelId);
  }
}
