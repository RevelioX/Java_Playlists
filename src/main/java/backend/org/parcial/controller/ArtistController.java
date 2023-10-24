package backend.org.parcial.controller;

import backend.org.parcial.entities.Artist;
import backend.org.parcial.services.ArtistService;
import backend.org.parcial.services.ArtistServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/artists")
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @GetMapping
    private ResponseEntity<List<Artist>> getAll(){
        List<Artist> lista = artistService.getAll();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    private ResponseEntity<Artist> getOne(@PathVariable("id") Long id){
        Artist artist = artistService.getById(id);
        if(artist == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(artist);
    }

    @PostMapping
    private ResponseEntity<Void> addArtist(@RequestBody Artist artist){
        System.out.println(artist.toString());
        artistService.add(artist);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @PutMapping()
    private ResponseEntity<Void> updateArtist(@RequestBody Artist artist){
        var valor = artistService.update(artist);
        if(!valor){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok().build();
    }
}
