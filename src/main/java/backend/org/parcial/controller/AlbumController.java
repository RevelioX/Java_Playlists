package backend.org.parcial.controller;

import backend.org.parcial.entities.Album;
import backend.org.parcial.entities.Artist;
import backend.org.parcial.services.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/albums")
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    @GetMapping
    private ResponseEntity<List<Album>> getAll(){
        List<Album> albums = albumService.getAll();
        return ResponseEntity.ok(albums);
    }

    @GetMapping("/{id}")
    private ResponseEntity<Album> getOne(@PathVariable("id") Long id){
        Album album = albumService.getById(id);
        if(album == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(album);
    }

    @PostMapping
    private ResponseEntity<Void> addAlbum(@RequestBody Album album){
        System.out.println(album.toString());
        albumService.add(album);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @PutMapping()
    private ResponseEntity<Void> updateAlbum(@RequestBody Album album){
        var valor = albumService.update(album);
        if(!valor){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok().build();}
}
