package backend.org.parcial.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

@Entity(name = "tracks")
@Data
@NoArgsConstructor
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Long trackId;

    @Column(name = "Name")
    private String name;

    @Column(name = "Composer")
    private String composer;

    @Column(name = "Milliseconds")
    private Long miliseconds;

    @Column(name = "Bytes")
    private Long bytes;

    @Column(name = "UnitPrice")
    private Double unitPrice;

    @ManyToOne
    @JoinColumn(name = "AlbumId")
    private Album album;

    @ManyToOne
    @JoinColumn(name = "MediaTypeId")
    private MediaType mediaType;

    @ManyToOne
    @JoinColumn(name = "GenreId")
    private Genre genre;
}
