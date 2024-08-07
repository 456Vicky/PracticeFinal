package com.example.practicefinal.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



@Entity
public class Savings {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int customerNumber;
    private String name;
    private double initialDeposit;
    private int numberOfYears;
    private String savingsType;

    public Savings() {
    }

    public Savings(int customerNumber, String name, double initialDeposit, int numberOfYears, String savingsType) {
        this.customerNumber = customerNumber;
        this.name = name;
        this.initialDeposit = initialDeposit;
        this.numberOfYears = numberOfYears;
        this.savingsType = savingsType;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getInitialDeposit() {
        return initialDeposit;
    }

    public void setInitialDeposit(double initialDeposit) {
        this.initialDeposit = initialDeposit;
    }

    public int getNumberOfYears() {
        return numberOfYears;
    }

    public void setNumberOfYears(int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    public String getSavingsType() {
        return savingsType;
    }

    public void setSavingsType(String savingsType) {
        this.savingsType = savingsType;
    }
}