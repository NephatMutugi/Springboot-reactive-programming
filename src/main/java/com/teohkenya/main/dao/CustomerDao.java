package com.teohkenya.main.dao;

import com.teohkenya.main.model.Customer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @ Author NMuchiri
 **/
@Component
public class CustomerDao {

    public List<Customer> getCustomers(){
        return IntStream.rangeClosed(1, 50)
                .peek(i -> System.out.println("Processing Count: " + i))
                .mapToObj(i -> new Customer(i, "customer " + i))
                .collect(Collectors.toList());
    }
}
