package vn.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.MedicalDeclaration;
import vn.codegym.repository.IRepository;

import java.util.List;

@Service
public class ServiceImp implements IService {


    @Autowired
    IRepository iRepository;


    @Override
    public MedicalDeclaration showDeclaredInfor() {
        return iRepository.showDeclaredInfor();
    }

    @Override
    public MedicalDeclaration saveInfor(MedicalDeclaration object) {
        return iRepository.saveInfor(object);
    }
}
