package com.xeline.webservice.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.xeline.webservice.model.Customer;

@Component
public class CustomerDAO {

    // Dummy database. Initialize with some dummy values.
    private static List<Customer> customers;
    {
        customers = new ArrayList();
        customers.add(new Customer(101, "user1", "name1", "test1@gmail.com", "121-232-3435"));
        customers.add(new Customer(201, "user2", "name2", "test2@gmail.com", "343-545-2345"));
        customers.add(new Customer(301, "user3", "name3", "test3@gmail.com", "876-237-2987"));
        customers.add(new Customer(System.currentTimeMillis(), "user4", "name4", "test4@gmail.com", "356-758-8736"));
    }

    public List list() {
        return customers;
    }

    public Customer get(Long id) {

        for (Customer c : customers) {
            if (c.getId().equals(id)) {
                return c;
            }
        }
        return null;
    }

    public Customer create(Customer customer) {
        customer.setId(System.currentTimeMillis());
        customers.add(customer);
        return customer;
    }

    public Long delete(Long id) {

        for (Customer c : customers) {
            if (c.getId().equals(id)) {
                customers.remove(c);
                return id;
            }
        }

        return null;
    }

    public Customer update(Long id, Customer customer) {

        for (Customer c : customers) {
            if (c.getId().equals(id)) {
                customer.setId(c.getId());
                customers.remove(c);
                customers.add(customer);
                return customer;
            }
        }

        return null;
    }

}