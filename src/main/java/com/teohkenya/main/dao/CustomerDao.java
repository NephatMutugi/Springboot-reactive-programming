package com.teohkenya.main.dao;

import com.teohkenya.main.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @ Author NMuchiri
 **/
@Component
@Slf4j
public class CustomerDao {

    public List<Customer> getCustomers(){
        return IntStream.rangeClosed(1, 50)
                .peek(CustomerDao::sleepThread)
                .peek(i -> System.out.println("Processing Count: " + i))
                .mapToObj(i -> new Customer(i, "customer " + i))
                .collect(Collectors.toList());
    }

    private static void sleepThread(int milliseconds){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.error("InterruptedException: {}", e.getMessage());
        }
    }

}
