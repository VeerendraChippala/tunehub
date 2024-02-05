package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entites.Playlist;

public interface playlistRepository 
			extends JpaRepository<Playlist, Integer>{

}
