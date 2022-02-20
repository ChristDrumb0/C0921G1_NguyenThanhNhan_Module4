package com.codegym.casestudy.service.imp.contract;

import com.codegym.casestudy.model.entity.contract.ContractDetail;
import com.codegym.casestudy.repository.contract.IContracDetailRepo;
import com.codegym.casestudy.service.contract.IContracDetailService;
import com.codegym.casestudy.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailImp implements IContracDetailService {
    @Autowired
    private IContracDetailRepo iContracDetailRepo;

    @Override
    public List<ContractDetail> findAll() {
        return iContracDetailRepo.findAll();
    }
}
