package com.fashionstore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fashionstore.Entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
