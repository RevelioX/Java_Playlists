package backend.org.parcial.controller;

import backend.org.parcial.entities.Playlist;
import backend.org.parcial.entities.Track;
import backend.org.parcial.services.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/playlists")
public class PlaylistController {
    @Autowired
    private PlaylistService playlistService;

    @GetMapping
    public ResponseEntity<List<Playlist>> getAll(){
        try {
            List<Playlist> playlists = playlistService.getAll();
            return ResponseEntity.ok(playlists);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    private ResponseEntity<Void> addPlaylist(@RequestBody Playlist playlist){
        playlistService.add(playlist);
        return ResponseEntity.ok().build()
                ;    }

    @PutMapping()
    private ResponseEntity<Void> updatePlaylist(@RequestBody Playlist playlist){
        var valor = playlistService.update(playlist);
        if(!valor){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    private ResponseEntity<Playlist> getOne(@PathVariable("id") Long id){
        Playlist playlist = playlistService.getById(id);
        if(playlist == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(playlist);
    }
}
