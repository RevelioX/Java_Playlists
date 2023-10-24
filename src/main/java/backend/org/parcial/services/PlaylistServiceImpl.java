package backend.org.parcial.services;

import backend.org.parcial.entities.Playlist;
import backend.org.parcial.entities.Track;
import backend.org.parcial.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaylistServiceImpl implements PlaylistService{

    @Autowired
    private PlaylistRepository playlistRepository;

    @Override
    public void add(Playlist entity) {
        playlistRepository.save(entity);
    }

    @Override
    public Playlist getById(Long aLong) {
        Optional<Playlist> playlists = playlistRepository.findById(aLong);
        return playlists.orElse(null);
    }

    @Override
    public List<Playlist> getAll() {
        List<Playlist> playlists = playlistRepository.findAll();
        return playlists;
    }

    @Override
    public boolean update(Playlist entity) {
        Playlist playlist = getById(entity.getPlaylistId());
        if (playlist == null) {
            return false;
        }
        if (entity.getName() != null && !entity.getName().isEmpty()) {
            playlist.setName(entity.getName());
        }
        if (entity.getTracks() != null) {
            playlist.setTracks(entity.getTracks());
        }
        playlistRepository.save(playlist);
        return true;
    }

    @Override
    public Playlist delete(Long aLong) {
        return null;
    }
}
