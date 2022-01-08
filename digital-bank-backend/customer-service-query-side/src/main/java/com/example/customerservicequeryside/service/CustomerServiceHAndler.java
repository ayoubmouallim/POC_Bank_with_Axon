package com.example.customerservicequeryside.service;

import com.dev.coreapi.events.CustomerCreatedEvent;
import com.example.customerservicequeryside.entities.Customer;
import com.example.customerservicequeryside.repositories.CustomerRepository;
import coreapi.query.GetAllCustomersQuery;
import coreapi.query.GetCustomerByIdQuery;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
@AllArgsConstructor
public class CustomerServiceHAndler {

    private CustomerRepository customerRepository;


    @EventHandler
    public void on(CustomerCreatedEvent event)
    {
        log.info("*******************");
        log.info("CustomerCreatedEvent received");
        Customer customer = new Customer();
        customer.setId(event.getId());
        customer.setEmail(event.getEmail());
        customer.setName(event.getName());

        customerRepository.save(customer);
    }








}
