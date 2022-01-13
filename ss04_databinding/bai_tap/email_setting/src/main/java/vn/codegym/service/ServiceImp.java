package vn.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.Email;
import vn.codegym.repository.IRepository;

import java.util.List;

@Service
public class ServiceImp implements IService {


    @Autowired
    IRepository iRepository;


    @Override
    public Email showDetailEmail() {
        return iRepository.showDetailEmail();
    }

    @Override
    public void update(Email updateEmail) {
        iRepository.update(updateEmail);
    }

    @Override
    public List<String> showLanguages() {
        return iRepository.showLanguages();
    }

    @Override
    public List<Integer> showPageSizeList() {
        return iRepository.showPageSizeList();
    }
}
