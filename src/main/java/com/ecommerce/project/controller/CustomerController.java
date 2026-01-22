package com.ecommerce.project.controller;

import com.ecommerce.project.model.Customer;
import com.ecommerce.project.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
     @GetMapping("/getCustomers")
    public ResponseEntity<List<Customer>> getAllCustomer(){
         List<Customer> customers = customerService.getCustomers();
         return new ResponseEntity<>(customers , HttpStatus.OK);
    }

    @PostMapping("addCustomer")
    public ResponseEntity<String> addCustomer(@RequestBody Customer customer){
         customerService.addCustomer(customer);
         return new ResponseEntity<>("Customer Added Successfully" , HttpStatus.CREATED);
    }

    @PutMapping("updateCustomer/{id}")
    public ResponseEntity<String> updateCustomer(@PathVariable Long id,@RequestBody Customer customer){
         if(customerService.updateCustomerById(id,customer)){
         return new ResponseEntity<>("Customer Updated with customer Id " + id + " successfully." , HttpStatus.CREATED);}
         else{
             return new ResponseEntity<>("Customer Not found" , HttpStatus.NOT_FOUND);
         }
    }

    @DeleteMapping("deleteCustomer/{id}")
     public ResponseEntity<String>  deleteCustomer(@PathVariable Long id){
       if( customerService.deleteCustomerById(id))
       {return new ResponseEntity<>("Customer Deleted with customer Id "+id+" successfully." , HttpStatus.OK);}
       else {
           return new ResponseEntity<>("Customer Not Found " , HttpStatus.NOT_FOUND);
       }
    }
}
