package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entites.Song;
import com.example.demo.service.SongService;


@Controller
public class SongController {
	@Autowired
	SongService service;
	@PostMapping("/addSong")
	public String addSong(@ModelAttribute Song song) {
		if(service.NameExists(song.getName())==false) {
			service.addSong(song);
			System.out.println("song added");
		}
		else {
			System.out.println("Song already present");
		}
		return "adminHome";
	}
	@GetMapping("/viewSong")
	public String viewSong(Model model) {
		List<Song> songs=service.fetchAll();
		model.addAttribute("songs", songs);
		return "displaySongs";
	}
	@GetMapping("/playSong")
	public String playSong(Model model) {
		boolean premium=true;
		if(premium) {
			List<Song> songs=service.fetchAll();
			model.addAttribute("songs", songs);
			return "displaySongs";
		}
		else {
			return "makePayment";
		}
	}
	
}
