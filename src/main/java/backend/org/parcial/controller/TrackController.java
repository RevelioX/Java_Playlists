package backend.org.parcial.controller;

import backend.org.parcial.entities.Artist;
import backend.org.parcial.entities.Track;
import backend.org.parcial.services.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tracks")
public class TrackController {

    @Autowired
    private TrackService trackService;

    @GetMapping
    private ResponseEntity<List<Track>> getAll(){
        List<Track> tracks = trackService.getAll();
        return ResponseEntity.ok(tracks);
    }

    @PostMapping
    private ResponseEntity<Void> addTrack(@RequestBody Track track){
        trackService.add(track);
        return ResponseEntity.ok().build()
;    }

    @PutMapping()
    private ResponseEntity<Void> updateArtist(@RequestBody Track track){
        var valor = trackService.update(track);
        if(!valor){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    private ResponseEntity<Track> getOne(@PathVariable("id") Long id){
        Track track = trackService.getById(id);
        if(track == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(track);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Track> deleteOne(@PathVariable("id") Long id){
        Track track = trackService.delete(id);
        return ResponseEntity.ok(track);
    }

}
