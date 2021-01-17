package com.lookify.song.repositories;

import com.lookify.song.models.Song;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends CrudRepository<Song, Long> {
    List<Song> findAll();

    List<Song> findByArtistContaining(String artist);

    List<Song> findByOrderByRatingDesc();
}
