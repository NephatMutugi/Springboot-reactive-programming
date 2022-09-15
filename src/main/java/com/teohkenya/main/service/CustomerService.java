package com.teohkenya.main.service;

import com.teohkenya.main.model.Customer;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * @ Author NMuchiri
 **/
public interface CustomerService {
    ResponseEntity<List<Customer>> loadAllCustomers();
}
