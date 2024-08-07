package com.example.practicefinal;


import com.example.practicefinal.model.Savings;
import com.example.practicefinal.repository.SavingsRepository;
import com.example.practicefinal.service.SavingsService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class SavingsServiceTest {

    @Mock
    private SavingsRepository repository;

    @InjectMocks
    private SavingsService service;

    public SavingsServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        when(repository.findAll()).thenReturn(new ArrayList<>());
        assertNotNull(service.findAll());
        verify(repository, times(1)).findAll();
    }

    @Test
    public void testFindById() {
        Savings savings = new Savings();
        when(repository.findById(1L)).thenReturn(Optional.of(savings));
        assertEquals(savings, service.findById(1L).get());
        verify(repository, times(1)).findById(1L);
    }

    @Test
    public void testSave() {
        Savings savings = new Savings();
        service.save(savings);
        verify(repository, times(1)).save(savings);
    }

    @Test
    public void testDeleteById() {
        service.deleteById(1L);
        verify(repository, times(1)).deleteById(1L);
    }

    @Test
    public void testExistsByCustomerNumber() {
        when(repository.existsByCustomerNumber(1)).thenReturn(true);
        assertTrue(service.existsByCustomerNumber(1));
        verify(repository, times(1)).existsByCustomerNumber(1);
    }
}
