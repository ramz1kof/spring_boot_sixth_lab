package ua.lviv.iot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Accessors(chain = true)
@Entity
public class Genre {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @EqualsAndHashCode.Include
  private Integer id;

  @Basic
  @Column(name = "name")
  private String name;

  @Basic
  @Column(name = "description")
  private String description;

  @JsonIgnore
  @ToString.Exclude
  @OneToMany(mappedBy = "genreByGenreId")
  private List<Album> albumsById;

  @JsonIgnore
  @ToString.Exclude
  @OneToMany(mappedBy = "genreByGenreId")
  private List<Song> songsById;
}
