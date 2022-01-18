package cg.wbd.grandemonstration.service.impl;

import cg.wbd.grandemonstration.model.Music;
import cg.wbd.grandemonstration.service.IService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class ServiceImpl implements IService {
    private static List<Music> music;
    private static long autoIncreaseId = 0;

    static {
        music = asList(
            new Music(autoIncreaseId++, "Ben Do", "Coldz", "Rock Rap", "https://www.youtube.com/watch?v=avS_FQ36Lwc"),
            new Music(autoIncreaseId++, "Dan Ong va Canh Cua", "Sea Chain", "Futuristic Bass","https://www.youtube.com/watch?v=6gyEwTyACek")

        );
    }

    @Override
    public List<Music> findAll() {
        return new ArrayList<>(music);
    }

    @Override
    public Music findOne(Long id) {
        return music.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Music save(Music music) {
        return music.getId() == null ? persist(music) : merge(music);
    }

    @Override
    public List<Music> save(List<Music> music) {
        return music.stream()
                .map(this::save)
                .collect(Collectors.toList());
    }

    @Override
    public boolean exists(Long id) {
        return music.stream().anyMatch(c -> c.getId().equals(id));
    }

    @Override
    public List<Music> findAll(List<Long> ids) {
        return ids.stream()
                .map(this::findOne)
                .collect(Collectors.toList());
    }

    @Override
    public long count() {
        return music.size();
    }

    @Override
    public void delete(Long id) {
        music.removeIf(c -> c.getId().equals(id));
    }

    @Override
    public void delete(Music music) {
        delete(music.getId());
    }

    @Override
    public void delete(List<Music> music) {
        music.forEach(this::delete);
    }

    @Override
    public void deleteAll() {
        music = new ArrayList<>();
    }

    private Music persist(Music music) {
        Music clone = music.clone();
        clone.setId(autoIncreaseId++);
        ServiceImpl.music.add(clone);
        return clone;
    }

    private Music merge(Music music) {
        Music origin = findOne(music.getId());
        origin.setName(music.getName());
        origin.setPerformer(music.getPerformer());
        origin.setType(music.getType());
        origin.setLink(music.getLink());
        return origin;
    }
}
