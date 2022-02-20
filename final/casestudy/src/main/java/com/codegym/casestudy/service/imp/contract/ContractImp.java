package com.codegym.casestudy.service.imp.contract;

import com.codegym.casestudy.model.entity.contract.Contract;
import com.codegym.casestudy.repository.contract.IContractRepo;
import com.codegym.casestudy.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContractImp implements IContractService {
    @Autowired
    private IContractRepo iContractRepo;

    @Override
    public Contract save(Contract object) {
        return iContractRepo.save(object);
    }

    @Override
    public Optional<Contract> findById(Long id) {
        return iContractRepo.findById(id);
    }

    @Override
    public Page<Contract> findCurrentCustomerPage(Pageable pageable) {
        return iContractRepo.findCurrentCustomerPage(pageable);
    }
}
