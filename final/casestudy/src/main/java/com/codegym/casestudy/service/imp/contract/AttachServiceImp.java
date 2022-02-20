package com.codegym.casestudy.service.imp.contract;

import com.codegym.casestudy.model.entity.contract.AttachService;
import com.codegym.casestudy.repository.contract.IAttatchServiceRepo;
import com.codegym.casestudy.service.contract.IAttachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachServiceImp implements IAttachService {
    @Autowired
    private IAttatchServiceRepo iAttatchServiceRepo;
    @Override
    public List<AttachService> findAll() {
        return iAttatchServiceRepo.findAll();
    }
}
