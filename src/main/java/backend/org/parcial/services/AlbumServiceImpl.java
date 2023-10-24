package backend.org.parcial.services;

import backend.org.parcial.entities.Album;
import backend.org.parcial.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private AlbumRepository albumRepository;
    @Override
    public void add(Album entity) {
        albumRepository.save(entity);
    }

    @Override
    public Album getById(Long aLong) {
        Optional<Album> album = albumRepository.findById(aLong);
        return album.orElse(null);
    }

    @Override
    public List<Album> getAll() {
        List<Album> albums = albumRepository.findAll();
        return albums;
    }

    @Override
    public boolean update(Album entity) {
        Album album = getById(entity.getAlbumId());
        if (album == null) {
            return false;
        }
        if (entity.getTitle() != null && !entity.getTitle().isEmpty()) {
            album.setTitle(entity.getTitle());
        }
        if (entity.getArtist() != null) {
            album.setArtist(entity.getArtist());
        }
        albumRepository.save(album);
        return true;
    }

    @Override
    public Album delete(Long aLong) {
        return null;
    }
}
