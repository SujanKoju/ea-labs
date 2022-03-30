package com.example.Lab2PartA;

import com.example.Lab2PartA.services.ICustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {
    private final ICustomerService customerService;


    public Application(ICustomerService customerService) {
        this.customerService = customerService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Override
    public void run(String... args) {
        customerService.addCustomer("Sujan", "kojusujan1111@gmail.com", "1000 North", "Iowa", "52557");
    }
}

