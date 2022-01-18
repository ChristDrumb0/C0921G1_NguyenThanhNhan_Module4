package cg.wbd.grandemonstration.service;

import cg.wbd.grandemonstration.model.Music;

import java.util.List;

public interface IService {
    List<Music> findAll();

    Music findOne(Long id);

    Music save(Music music);

    List<Music> save(List<Music> music);

    boolean exists(Long id);

    List<Music> findAll(List<Long> ids);

    long count();

    void delete(Long id);

    void delete(Music music);

    void delete(List<Music> music);

    void deleteAll();
}
