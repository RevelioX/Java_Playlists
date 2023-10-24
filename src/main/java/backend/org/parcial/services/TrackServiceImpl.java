package backend.org.parcial.services;

import backend.org.parcial.entities.Track;
import backend.org.parcial.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TrackServiceImpl implements TrackService{

    @Autowired
    private TrackRepository trackRepository;
    @Override
    public void add(Track entity) {
        trackRepository.save(entity);
    }



    @Override
    public Track getById(Long aLong) {
            Optional<Track> tracks = trackRepository.findById(aLong);
            return tracks.orElse(null);
    }

    @Override
    public List<Track> getAll() {
        List<Track> tracks = trackRepository.findAll();
        return tracks;
    }

    @Override
    public boolean update(Track entity) {
        Track track = getById(entity.getTrackId());
        if(track == null){
            return false;
        }
        if (entity.getComposer() != null && !entity.getComposer().isEmpty()) {
            track.setComposer(entity.getComposer());
        }
        if (entity.getMiliseconds() != null) {
            track.setMiliseconds(entity.getMiliseconds());
        }
        if (entity.getBytes() != null) {
            track.setBytes(entity.getBytes());
        }
        if (entity.getUnitPrice() != null) {
            track.setUnitPrice(entity.getUnitPrice());
        }
        if (entity.getName() != null && !entity.getName().isEmpty()) {
            track.setName(entity.getName());
        }
        if (entity.getMediaType() != null) {
            track.setMediaType(entity.getMediaType());
        }
        if (entity.getGenre() != null) {
            track.setGenre(entity.getGenre());
        }
        trackRepository.save(track);
        return true;
    }

    @Override
    public Track delete(Long aLong) {
        Optional<Track> track = trackRepository.findById(aLong);
        trackRepository.delete(track.orElseThrow());
        return track.orElseThrow();
    }
}
