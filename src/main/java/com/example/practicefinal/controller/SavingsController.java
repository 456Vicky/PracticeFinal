package com.example.practicefinal.controller;

import com.example.practicefinal.model.Savings;
import com.example.practicefinal.service.SavingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/savings")
public class SavingsController {

    @Autowired
    private SavingsService service;

    @GetMapping
    public String listSavings(Model model) {
        model.addAttribute("savingsList", service.findAll());
        return "list";
    }

    @GetMapping("/add")
    public String addSavingsForm(Model model) {
        model.addAttribute("savings", new Savings());
        return "add";
    }

    @PostMapping("/add")
    public String addSavings(Savings savings, Model model) {
        if (service.existsByCustomerNumber(savings.getCustomerNumber())) {
            model.addAttribute("error", "Customer number already exists");
            return "add";
        }
        service.save(savings);
        return "redirect:/savings";
    }

    @GetMapping("/edit/{id}")
    public String editSavingsForm(@PathVariable Long id, Model model) {
        Optional<Savings> savings = service.findById(id);
        if (savings.isPresent()) {
            model.addAttribute("savings", savings.get());
            return "edit";
        } else {
            return "redirect:/savings";
        }
    }

    @PostMapping("/edit")
    public String editSavings(Savings savings) {
        service.save(savings);
        return "redirect:/savings";
    }

    @GetMapping("/delete/{id}")
    public String deleteSavings(@PathVariable Long id) {
        service.deleteById(id);
        return "redirect:/savings";
    }

    @GetMapping("/projected/{id}")
    public String projectedSavings(@PathVariable Long id, Model model) {
        Optional<Savings> savings = service.findById(id);
        if (savings.isPresent()) {
            Savings savingsRecord = savings.get();
            List<Projection> projections = calculateProjections(savingsRecord);
            model.addAttribute("savings", savingsRecord);
            model.addAttribute("projections", projections);
            return "projected";
        } else {
            return "redirect:/savings";
        }
    }


    private List<Projection> calculateProjections(Savings savings) {
        List<Projection> projections = new ArrayList<>();
        double rate = savings.getSavingsType().equalsIgnoreCase("De-luxe") ? 0.15 : 0.10;
        double balance = savings.getInitialDeposit();

        for (int year = 1; year <= savings.getNumberOfYears(); year++) {
            double interest = balance * rate;
            balance += interest;
            projections.add(new Projection(year, interest, balance));
        }

        return projections;
    }

    private static class Projection {
        private int year;
        private double interest;
        private double endingBalance;

        public Projection(int year, double interest, double endingBalance) {
            this.year = year;
            this.interest = interest;
            this.endingBalance = endingBalance;
        }

        public int getYear() {
            return year;
        }

        public double getInterest() {
            return interest;
        }

        public double getEndingBalance() {
            return endingBalance;
        }
    }
}
