package com.example.demo.service;

import java.util.List;

import com.example.demo.entites.Song;

public interface SongService {

	public void addSong(Song song);

	public List<Song> fetchAll();

	public boolean NameExists(String name);
	
	public void updateSong(Song song);

}
