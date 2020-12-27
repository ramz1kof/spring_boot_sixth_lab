package ua.lviv.iot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Accessors(chain = true)
@Entity
@Table(name = "record_label", schema = "ostap_koziaryk_itunes_full")
public class RecordLabel {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @EqualsAndHashCode.Include
  private Integer id;

  @Basic
  @Column(name = "name")
  private String name;

  @JsonIgnore
  @ToString.Exclude
  @ManyToMany
  @JoinTable(name = "record_label_album", schema = "ostap_koziaryk_itunes_full",
      joinColumns = @JoinColumn(name = "record_label_id", referencedColumnName = "id",
          nullable = false),
      inverseJoinColumns = @JoinColumn(name = "album_id", referencedColumnName = "id",
          nullable = false))
  private Set<Album> albums;
}
