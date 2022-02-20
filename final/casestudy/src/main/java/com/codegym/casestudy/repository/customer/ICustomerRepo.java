package com.codegym.casestudy.repository.customer;

import com.codegym.casestudy.model.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepo extends JpaRepository<Customer,Long> {

    @Query(value = "SELECT id,`name`, `code`,address,day_of_birth, email, gender, id_card, phone,customer_type_type_id\n" +
            "FROM customer c\n" +
            "WHERE (?1 IS NULL OR c.name LIKE %?1% )\n" +
            "AND (?2 IS NULL OR customer_type_type_id = ?2)",

            countQuery = "SELECT id,`name`, `code`,address,day_of_birth, email, gender, id_card, phone,customer_type_type_id\n" +
                    "FROM customer c\n" +
                    "WHERE (?1 IS NULL OR c.name LIKE %?1% )\n" +
                    "AND (?2 IS NULL OR customer_type_type_id = ?2)",
            nativeQuery = true)
    Page<Customer> findAll(String name, Integer customerTypeId, Pageable pageable);
}
