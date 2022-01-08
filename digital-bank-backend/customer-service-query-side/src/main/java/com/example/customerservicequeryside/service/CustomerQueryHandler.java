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
@Slf4j
@AllArgsConstructor
public class CustomerQueryHandler {

    private CustomerRepository customerRepository;


    @QueryHandler
    public List<Customer>  getCustomers(GetAllCustomersQuery query)
    {
        return customerRepository.findAll();
    }


    @QueryHandler
    public Customer getCustomerbyId(GetCustomerByIdQuery query)
    {
        return customerRepository.findById(query.getId()).orElseThrow(
            ()->new RuntimeException("Customer not found")
        );
    }




}
