package backend.org.parcial.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.lang.NonNull;

@Entity(name = "artists")
@NoArgsConstructor
@Data
@ToString
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Long artistId;

    @Column(name = "Name")
    private String name;

    public Artist(String name) {
        this.name = name;
    }
}
