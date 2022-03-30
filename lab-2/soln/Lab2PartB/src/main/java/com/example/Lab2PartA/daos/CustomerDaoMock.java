package com.example.Lab2PartA.daos;

import com.example.Lab2PartA.domains.Customer;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * @author kojusujan1111@gmail.com 29/03/22
 */
@Service
@Profile("test")
public class CustomerDaoMock implements ICustomerDAO {
    @Override
    public void save(Customer customer) {
        System.out.println("--- CUSTOMER SAVED FORM CUSTOMER DOA MOCK ---");
    }
}
