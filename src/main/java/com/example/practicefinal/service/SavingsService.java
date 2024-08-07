package com.example.practicefinal.service;

import com.example.practicefinal.model.Savings;
import com.example.practicefinal.repository.SavingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SavingsService {
    @Autowired
    private SavingsRepository repository;

    public Iterable<Savings> findAll() {
        return repository.findAll();
    }

    public Optional<Savings> findById(Long id) {
        return repository.findById(id);
    }

    public void save(Savings savings) {
        repository.save(savings);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public boolean existsByCustomerNumber(int customerNumber) {
        return repository.existsByCustomerNumber(customerNumber);
    }
}
