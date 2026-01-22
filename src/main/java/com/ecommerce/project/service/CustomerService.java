package com.ecommerce.project.service;

import com.ecommerce.project.model.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> getCustomers();

    void addCustomer(Customer customer);

    boolean updateCustomerById(Long id , Customer customer);

    boolean deleteCustomerById(Long id);
}
