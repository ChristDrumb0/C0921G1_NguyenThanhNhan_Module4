package com.codegym.casestudy.service.contract;

import com.codegym.casestudy.model.entity.contract.ContractDetail;

import java.util.List;

public interface IContracDetailService {

    public List<ContractDetail> findAll();
}
