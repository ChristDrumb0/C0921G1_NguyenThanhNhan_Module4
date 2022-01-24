package com.codegym.song.service;

import com.codegym.song.entity.Song;
import com.codegym.song.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongServiceImp implements ISongService{
    @Autowired
    ISongRepository repository;

    @Override
    public List<Song> findAll(){
        return repository.findAll();
    }

    @Override
    public Page<Song> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Optional<Song> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public void save(Song song) {
        repository.save(song);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
