package backend.org.parcial.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

@Entity(name = "media_types")
@Data
@NoArgsConstructor

public class MediaType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Long mediaTypeId;

    @Column(name = "Name")
    private String name;
}
