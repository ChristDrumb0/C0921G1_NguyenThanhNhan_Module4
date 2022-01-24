package com.codegym.song.service;

import com.codegym.song.entity.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ISongService {
    List<Song> findAll();
    Page<Song> findAll(Pageable pageable);
    Optional<Song> findById(Integer id);
    void save(Song song);
    void delete(Integer id);

}
