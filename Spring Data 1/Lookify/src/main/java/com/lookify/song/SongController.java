package com.lookify.song;

import com.lookify.song.models.Song;
import com.lookify.song.services.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class SongController {
    private final SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }
    @RequestMapping("")
    public String Home(){
        return "home.jsp";
    }
    @RequestMapping("/songs")
    public String main(Model model){
        List<Song>songs =songService.allSongs();
        model.addAttribute("songs",songs);
        return "main.jsp";
    }
    @RequestMapping("/songs/{id}")
    public String show(@PathVariable("id")Long id,Model model){
        Song song =songService.findSong(id);
        model.addAttribute("song",song);
        return "show.jsp";
    }
    @RequestMapping("/songs/{id}/delete")
    public String destroy(@PathVariable("id")Long id){
        songService.delete(id);
        return "redirect:/songs";
    }
    @RequestMapping("/songs/new")
    public String newSong(@ModelAttribute("song") Song song) {
        return "new.jsp";
    }
    @RequestMapping(value="/songs", method= RequestMethod.POST)
    public String create(@Valid @ModelAttribute("song") Song song, BindingResult result) {
        if (result.hasErrors()) {
            return "new.jsp";
        } else {
            songService.createSong(song);
            return "redirect:/songs";
        }
    }
    @RequestMapping(value = "/search")
    public String search(@RequestParam(value = "artist")String artist,Model model){
        List<Song> songs=songService.findArtists(artist);
        model.addAttribute("songs",songs);
        return "search.jsp";
    }
    @RequestMapping("/songs/top")
    public String top(Model model){
        List<Song> songs=songService.sortByRating();
        model.addAttribute("songs",songs);
        return "top.jsp";
    }
}
