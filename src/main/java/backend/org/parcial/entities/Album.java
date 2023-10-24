package backend.org.parcial.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

@Entity(name = "albums")
@Data
@NoArgsConstructor
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private long albumId;

    @Column(name = "Title")
    @NotNull
    private String title;

    @ManyToOne
    @JoinColumn(name = "ArtistId")
    private Artist artist;


}
