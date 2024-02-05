package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entites.Playlist;
import com.example.demo.repository.playlistRepository;

@Service
public class PlaylistServiceImpl implements PlaylistService{
	@Autowired
	playlistRepository repo;
	@Override
	public void addPlaylist(Playlist playlist) {
		repo.save(playlist);
		
	}
	@Override
	public List<Playlist> fetchPlaylist() {
		return repo.findAll();
	}

}
