package backend.org.parcial.services;

import backend.org.parcial.entities.Artist;
import backend.org.parcial.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistServiceImpl implements ArtistService{

    @Autowired
    private ArtistRepository artistRepository;

    @Override
    public void add(Artist entity) {
        artistRepository.save(entity);
    }

    @Override
    public Artist getById(Long aLong) {
        Optional<Artist> artist = artistRepository.findById(aLong);
        return artist.orElse(null);
    }

    @Override
    public List<Artist> getAll() {
        List<Artist> lista = artistRepository.findAll();
        return lista;
    }

    @Override
    public boolean update(Artist entity) {
        Artist artist = getById(entity.getArtistId());
        if (artist == null) {
            return false;
        }
        if (entity.getName() != null && !entity.getName().isEmpty()) {
            artist.setName(entity.getName());
        }
        artistRepository.save(artist);
        return true;
    }

    @Override
    public Artist delete(Long aLong) {
        return null;
    }
}
