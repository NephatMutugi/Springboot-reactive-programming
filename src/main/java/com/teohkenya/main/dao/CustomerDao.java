package com.teohkenya.main.dao;

import com.teohkenya.main.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
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

    public Flux<Customer> getCustomersStream(){
        return Flux.range(1, 50)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(i -> System.out.println("Processing count: " + i))
                .map(i -> new Customer(i, "Customer " + i));
    }




    /**
     * Use this thread to sleep the working thread for one second.
     * This is useful in demonstrating the blocking nature of sync processing*/
    private static void sleepThread(int milliseconds){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.error("InterruptedException: {}", e.getMessage());
        }
    }

}
