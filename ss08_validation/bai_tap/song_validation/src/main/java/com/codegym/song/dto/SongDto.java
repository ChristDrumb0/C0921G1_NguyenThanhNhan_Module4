package com.codegym.song.dto;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;

@Component
public class SongDto implements Validator {

    private Integer id;
    @NotBlank (message = "This field should not be Blank")
    private String name;
    @NotBlank (message = "This field should not be Blank")
    private String singer;
    @NotBlank (message = "This field should not be Blank")
    private String type;
    private String link;

    public SongDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
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
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SongDto songDto = (SongDto) target;
        //validate Name:
//        if (songDto.name.isEmpty()) {
//            errors.rejectValue("name","field.empty","KHONG duoc de trong truong nay");
//        }
        if (songDto.name.length() > 10) {
            errors.rejectValue("name","name.length","DO NOT exceed 800 characters");
        }
        if (!songDto.name.matches("^[a-zA-Z0-9 ]+$")) {
            errors.rejectValue("name","field.forbidden","DO NOT include special characters:  @ ; , . = - + , ….");
        }
        //validate singer:
//        if (songDto.singer.isEmpty()) {
//            errors.rejectValue("singer","field.empty","KHONG duoc de trong truong nay");
//        }
        if (songDto.singer.length() > 10) {
            errors.rejectValue("singer","singerName.length","DO NOT exceed 300 characters");
        }
        if (!songDto.singer.matches("^[a-zA-Z0-9 ]+$")) {
            errors.rejectValue("singer","field.forbidden","DO NOT include special characters:  @ ; , . = - + , ….");
        }
        //validate song type:
//        if (songDto.type.isEmpty()) {
//            errors.rejectValue("musicGenre","field.empty","KHONG duoc de trong truong nay");
//        }
        if (songDto.singer.length() > 10) {
            errors.rejectValue("type","type.length","DO NOT exceed 1000 characters");
        }
        if (!songDto.singer.matches("^[a-zA-Z0-9, ]+$")) {
            errors.rejectValue("type","type.forbidden","DO NOT include special characters:  @ ; , . = - + , ….");
        }
    }
}
