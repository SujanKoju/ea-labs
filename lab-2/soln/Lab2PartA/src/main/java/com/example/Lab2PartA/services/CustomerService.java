package com.example.Lab2PartA.services;

import com.example.Lab2PartA.daos.ICustomerDAO;
import com.example.Lab2PartA.domains.Address;
import com.example.Lab2PartA.domains.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    private final ICustomerDAO customerDAO;
    private final IEmailSender emailService;

    @Autowired
    public CustomerService(ICustomerDAO customerDAO, IEmailSender emailService) {
        this.customerDAO = customerDAO;
        this.emailService = emailService;
    }

    public void addCustomer(String name, String email, String street, String city, String zip) {
        Customer customer = new Customer(name, email);
        Address address = new Address(street, city, zip);
        customer.setAddress(address);
        customerDAO.save(customer);
        emailService.sendEmail(email, "Welcome " + name + " as a new customer");
    }
}
