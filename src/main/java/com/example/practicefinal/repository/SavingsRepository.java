package com.example.practicefinal.repository;

import com.example.practicefinal.model.Savings;
import org.springframework.data.repository.CrudRepository;

public interface SavingsRepository extends CrudRepository<Savings, Long> {
    boolean existsByCustomerNumber(int customerNumber);
}


