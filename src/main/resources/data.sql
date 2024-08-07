CREATE TABLE savingstable (
                              id INT AUTO_INCREMENT PRIMARY KEY,
                              customer_number INT NOT NULL,
                              name VARCHAR(255) NOT NULL,
                              initial_deposit DOUBLE NOT NULL,
                              number_of_years INT NOT NULL,
                              savings_type VARCHAR(50) NOT NULL
);

-- Sample data
INSERT INTO savingstable (customer_number, name, initial_deposit, number_of_years, savings_type) VALUES
                                                                                                     (1, 'John Doe', 1000.0, 5, 'Savings Regular'),
                                                                                                     (2, 'Jane Doe', 2000.0, 3, 'Savings De-luxe');
