package com.codegym.casestudy.repository.contract;

import com.codegym.casestudy.model.entity.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IContractRepo extends JpaRepository<Contract,Long> {
    @Query(value = "SELECT * FROM Contract c WHERE c.start_date <= current_date AND c.end_date >=current_date", nativeQuery = true)
    Page<Contract> findCurrentCustomerPage (Pageable pageable);
}
