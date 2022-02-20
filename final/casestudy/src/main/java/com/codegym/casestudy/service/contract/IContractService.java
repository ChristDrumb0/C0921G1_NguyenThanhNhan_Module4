package com.codegym.casestudy.service.contract;

import com.codegym.casestudy.model.entity.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IContractService {

    Contract save (Contract object);

    Optional<Contract> findById(Long id);

    Page<Contract> findCurrentCustomerPage(Pageable pageable);
}
