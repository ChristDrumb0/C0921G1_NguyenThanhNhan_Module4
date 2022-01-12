package vn.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.repository.IRepository;
@Service
public class ServiceImp implements IService {


    @Autowired
    IRepository iRepository;


    @Override
    public String calculate(double first, double second, String operator) {
        return iRepository.calculate(first,second,operator);
    }
}
