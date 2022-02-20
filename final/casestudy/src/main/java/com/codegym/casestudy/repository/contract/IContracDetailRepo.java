package com.codegym.casestudy.repository.contract;

import com.codegym.casestudy.model.entity.contract.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContracDetailRepo extends JpaRepository<ContractDetail,Long> {
}
