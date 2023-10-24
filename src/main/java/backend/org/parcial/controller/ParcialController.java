package backend.org.parcial.controller;

import backend.org.parcial.entities.Album;
import backend.org.parcial.entities.Playlist;
import backend.org.parcial.entities.Track;
import backend.org.parcial.services.AlbumService;
import backend.org.parcial.services.PlaylistService;
import backend.org.parcial.services.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parcial")
public class ParcialController {

    @Autowired
    private TrackService trackService;

    @Autowired
    private PlaylistService playlistService;

    @Autowired
    private AlbumService albumService;

    @PostMapping("/newPlaylist")
    private ResponseEntity<Void> crearPlaylist(@RequestBody Playlist playlist){
        List<Track> tracks = playlist.getTracks();
        tracks.stream().forEach( track -> {
            Album album = track.getAlbum();
            albumService.add(album);
            trackService.add(track);
        });
        playlistService.add(playlist);
        return ResponseEntity.ok().build();
    }
}
