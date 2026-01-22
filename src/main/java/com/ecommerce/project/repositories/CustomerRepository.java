package com.ecommerce.project.repositories;

import com.ecommerce.project.model.Customer;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer , Long> {
    @Query(value = "select * from customer" , nativeQuery = true)
      List<Customer> getAllCustomers();
    @Modifying
    @Transactional
    @Query(value = "insert into customer(customer_name , email) values(:name , :email)",nativeQuery = true)
    void addCustomer(@Param("name") String name , @Param("email") String email);


    @Modifying
    @Transactional
    @Query(value = "update customer set customer_name = :name ,email = :email where id = :id " , nativeQuery = true)
   void updateCustomerById(@Param("name") String customerName,@Param("email") String email,@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value ="delete from customer where id = :id" , nativeQuery = true )
    void deleteCustomerById(@Param("id") Long id);

    @Query(value = "select * from customer where id = :id" , nativeQuery = true)
    Customer getCustomersById(@Param("id") Long id);
}
