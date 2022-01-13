package vn.codegym.service;

import org.springframework.stereotype.Service;
import vn.codegym.model.Email;

import java.util.List;


public interface IService {

    public Email showDetailEmail();

    public void update(Email updateEmail);

    public List<String> showLanguages();

    public List<Integer> showPageSizeList();

}
