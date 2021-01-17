package com.lookify.song.controllers;

import com.lookify.song.models.Song;
import com.lookify.song.repositories.SongRepository;
import com.lookify.song.services.SongService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SongApi {
public final SongService songService;

    public SongApi( SongService songService) {
        this.songService = songService;
    }
    @RequestMapping("/api/songs")
    public List<Song> index(){
        return songService.allSongs();
    }
    @RequestMapping(value = "/api/songs",method = RequestMethod.POST)
    public Song create(@RequestParam(value = "title")String title, @RequestParam(value = "artist")String artist, @RequestParam(value = "rating")Integer rating){
        Song song=new Song(title,artist,rating);
        return songService.createSong(song);
    }
    @RequestMapping("/api/songs/{id}")
    public Song show(@PathVariable("id") Long id){
        Song song=songService.findSong(id);
        return song;
    }


}
