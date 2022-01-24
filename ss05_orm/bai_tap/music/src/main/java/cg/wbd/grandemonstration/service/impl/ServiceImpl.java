package cg.wbd.grandemonstration.service.impl;

import cg.wbd.grandemonstration.model.Music;
import cg.wbd.grandemonstration.repository.IRepository;
import cg.wbd.grandemonstration.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class ServiceImpl implements IService {

    @Autowired
    IRepository repository;

    @Override
    public List<Music> findAll() {
        return repository.findAll();
    }

    @Override
    public Music findOne(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Music save(Music music) {
        return repository.save(music);
    }

    @Override
    public List<Music> save(List<Music> music) {
        return repository.save(music);
    }

    @Override
    public boolean exists(Long id) {
        return repository.exists(id);
    }

    @Override
    public List<Music> findAll(List<Long> ids) {
        return repository.findAll(ids);
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }

    @Override
    public void delete(Music music) {
        repository.delete(music);
    }

    @Override
    public void delete(List<Music> music) {
        repository.delete(music);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

}
