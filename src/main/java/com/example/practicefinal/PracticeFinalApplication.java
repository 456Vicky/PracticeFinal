package com.example.practicefinal;

import com.example.practicefinal.model.Savings;
import com.example.practicefinal.repository.SavingsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PracticeFinalApplication {

    public static void main(String[] args) {
        SpringApplication.run(PracticeFinalApplication.class, args);

    }

        @Bean
        public CommandLineRunner loadData (SavingsRepository repository){
            return (args) -> {
                // Add sample data
                repository.save(new Savings(1, "Alice Johnson", 5000.00, 5, "Savings Regular"));
                repository.save(new Savings(2, "Bob Smith", 15000.00, 10, "Savings De-luxe"));
                repository.save(new Savings(3, "Charlie Brown", 3000.00, 3, "Savings Regular"));
            };
        }
    }