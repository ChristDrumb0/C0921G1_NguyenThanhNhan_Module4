package com.codegym.casestudy.repository.contract;

import com.codegym.casestudy.model.entity.contract.AttachService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAttatchServiceRepo extends JpaRepository<AttachService,Long> {
}
