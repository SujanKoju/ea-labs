package com.example.Lab2PartA.daos;

import com.example.Lab2PartA.services.ILogger;
import com.example.Lab2PartA.domains.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class CustomerDAO implements ICustomerDAO {
    private final ILogger logger;

    @Autowired
    public CustomerDAO(ILogger logger) {
        this.logger = logger;
    }

    public void save(Customer customer) {
        try {
            Thread.sleep(350);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("CustomerDAO: saving customer " + customer.getName());
        logger.log("Customer is saved in the DB: " + customer.getName());
    }

}
