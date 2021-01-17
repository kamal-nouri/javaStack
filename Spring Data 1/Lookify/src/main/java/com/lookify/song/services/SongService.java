package com.lookify.song.services;

import com.lookify.song.models.Song;
import com.lookify.song.repositories.SongRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongService {
    private final SongRepository songRepository;

    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public List<Song> allSongs() {
        return songRepository.findAll();
    }

    public Song findSong(Long id) {
        Optional<Song> optionalSong = songRepository.findById(id);
        if (optionalSong.isPresent()) {
            return optionalSong.get();
        } else {
            return null;
        }
    }
    public List<Song> sortByRating(){
        return songRepository.findByOrderByRatingDesc();
    }
    public List<Song> findArtists(String artist) {
        return songRepository.findByArtistContaining(artist);
    }
    public Song createSong(Song song) {
        return songRepository.save(song);
    }

    public Song updateSong(Song song) {
        Song updatedSong = songRepository.findById(song.getId()).orElse(null);
        assert updatedSong != null;
        updatedSong.setTitle(song.getTitle());
        updatedSong.setArtist(song.getArtist());
        updatedSong.setRating(song.getRating());
        songRepository.save(updatedSong);
        return song;
    }

    public void delete(Long id) {
        songRepository.deleteById(id);
    }

}
