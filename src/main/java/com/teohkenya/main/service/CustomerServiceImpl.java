package com.teohkenya.main.service;

import com.teohkenya.main.dao.CustomerDao;
import com.teohkenya.main.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

/**
 * @ Author NMuchiri
 **/
@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService{

    final CustomerDao customerDao;

    @Autowired
    public CustomerServiceImpl(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public ResponseEntity<List<Customer>> loadAllCustomers() {

        long startTimer = System.currentTimeMillis();
        log.info("START TIME:: {}", startTimer);

        List<Customer> customers = customerDao.getCustomers();

        long lastTimer = System.currentTimeMillis();
        log.info("END TIME:: {}", lastTimer);
        log.info("TOTAL EXECUTION TIME:: {}", (lastTimer-startTimer));

        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Flux<Customer>> loadAllCustomersStream() {
        long start = System.currentTimeMillis();

        Flux<Customer> customerFlux = customerDao.getCustomersStream();

        long stop = System.currentTimeMillis();
        log.info("EXECUTION TIME: {}", (stop - start));

        return new ResponseEntity<>(customerFlux, HttpStatus.OK);
    }
}
