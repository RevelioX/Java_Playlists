package backend.org.parcial.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import java.util.List;

@Entity(name ="playlists")
@Data
@NoArgsConstructor
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Long playlistId;

    @Column(name = "Name")
    private String name;

    @ManyToMany
    @JoinTable( name = "playlist_track", joinColumns = @JoinColumn(name = "PlaylistId"),
    inverseJoinColumns = @JoinColumn(name = "TrackId"))
    private List<Track> tracks;
}
