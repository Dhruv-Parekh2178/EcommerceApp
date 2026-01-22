package com.ecommerce.project.service;

import com.ecommerce.project.model.Customer;
import com.ecommerce.project.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public List<Customer> getCustomers() {
        return customerRepository.getAllCustomers();
    }

    @Override
    public void addCustomer(Customer customer) {
        customerRepository.addCustomer(customer.getCustomerName() ,customer.getEmail());
    }

    @Override
    public boolean updateCustomerById(Long id, Customer customer) {
        if(customerRepository.getCustomersById(id) == null){
            return false;
        }
        customerRepository.updateCustomerById(customer.getCustomerName(),customer.getEmail(),id);
        return true;
    }

    @Override
    public boolean deleteCustomerById(Long id) {
        if(customerRepository.getCustomersById(id) == null){
            System.out.println("Customer Not Found");
           return false;
        }
        customerRepository.deleteCustomerById(id);
        return true;
    }
}
