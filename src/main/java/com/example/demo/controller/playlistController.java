package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entites.Playlist;
import com.example.demo.entites.Song;
import com.example.demo.service.PlaylistService;
import com.example.demo.service.SongService;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class playlistController {
	@Autowired
	SongService service;
	@Autowired
	PlaylistService playlistService;
	@GetMapping("/createPlaylist")
	public String createPlaylist(Model model) {
		List<Song> songs =service.fetchAll();
		model.addAttribute("songs", songs);
		return "createPlaylist";
	}
	@PostMapping("/addPlaylist")
	public String addPlaylist(@ModelAttribute Playlist playlist) {
		playlistService.addPlaylist(playlist);
		List<Song> songlist=playlist.getSongs();
		for (Song song : songlist) {
			song.getPlaylist().add(playlist);
			service.updateSong(song);
		}
		return "adminHome";
	}
	@GetMapping("/viewPlaylist")
	public String viewPlaylist(Model model) {
		List<Playlist> allPlaylist=playlistService.fetchPlaylist();
		model.addAttribute("allPlaylist", allPlaylist);
		return "displayPlaylist";
	}
	
	
	
}
