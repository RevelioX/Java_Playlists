package backend.org.parcial.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

@Entity(name = "Genres")
@Data
@NoArgsConstructor
public class Genre
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Long genreId;

    @Column(name = "Name")
    private String name;
}
