package com.example.customerservicecommandside.controllers;

import com.dev.coreapi.commands.CreateCustomerCommand;
import com.dev.coreapi.dtos.CustomerRequestDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@RestController
@Slf4j
@RequestMapping("/customers/commands")
@CrossOrigin("*")
public class CustomerController {
    private CommandGateway commandGateway;
    private EventStore eventStore;

    public CustomerController(CommandGateway commandGateway,EventStore eventStore) {
        this.commandGateway = commandGateway;
        this.eventStore = eventStore;
    }

    @PostMapping("/create")
    public CompletableFuture<String> createCustomer(@RequestBody CustomerRequestDto request) {

        CompletableFuture<String> response = commandGateway.send(new CreateCustomerCommand(
            UUID.randomUUID().toString(),
            request.getName(),
            request.getEmail()
        ));
        return response;
    }

    @GetMapping("/eventStore/{customerId}")
    public Stream eventStore(@PathVariable String customerId) {
        return eventStore.readEvents(customerId).asStream();
    }

}
