package cg.wbd.grandemonstration.model;

public class Music implements Cloneable {
    private Long id;
    private String name;
    private String performer;
    private String type;
    private String link;

    public Music() {
    }

    public Music(String name, String performer, String type, String link) {
        this.name = name;
        this.performer = performer;
        this.type = type;
        this.link = link;
    }

    public Music(Long id, String name, String performer, String type, String link) {
        this.id = id;
        this.name = name;
        this.performer = performer;
        this.type = type;
        this.link = link;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }


    @Override
    public Music clone() {
        Music music = new Music();
        music.setId(id);
        music.setName(name);
        music.setPerformer(performer);
        music.setType(type);
        music.setLink(link);
        return music;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", performer='" + performer + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
