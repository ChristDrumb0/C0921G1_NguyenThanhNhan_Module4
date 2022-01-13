package vn.codegym.repository;

import org.springframework.stereotype.Repository;
import vn.codegym.model.Email;

import java.util.List;


public interface IRepository {
    public Email showDetailEmail();

    public void update(Email updateEmail);

    public List<String> showLanguages();

    public List<Integer> showPageSizeList();
}
