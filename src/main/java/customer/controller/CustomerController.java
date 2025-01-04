package customer.controller;

import customer.data.*;
import customer.data.db.CustomerDbRepository;
import customer.service.AdditionalDetailsService;
import customer.service.CustomerService;
import customer.service.impl.CustomerServiceImpl;
import customer.service.impl.db.CustomerDbServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/v1/customer")
public class CustomerController {
    private static final Logger logger = LogManager.getLogger(CustomerController.class);

    private final CustomerService customerService;

    private final AdditionalDetailsService additionalDetailsService;


    public CustomerController(CustomerService customerService, AdditionalDetailsService additionalDetailsService) {
        this.customerService = customerService;
        this.additionalDetailsService = additionalDetailsService;
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public AddCustomerResponse addCustomer(@RequestBody AddCustomerRequest addCustomerRequest) {
        if (addCustomerRequest.getEmail() == null) {
            throw new IllegalArgumentException("Email cannot be null");
        }
        logger.info("Add customer called with request: {}",addCustomerRequest);
        String userId = customerService.addCustomer(addCustomerRequest);

        AddCustomerResponse response = new AddCustomerResponse();
        response.setUserId(userId);
        return response;
    }

    @GetMapping(
            produces = {MediaType.APPLICATION_JSON_VALUE}

    )
public ResponseEntity<GetCustomerResponse> getCustomerResponse (@RequestParam String userId){
        Customer customer = customerService.getCustomer(userId);
        GetCustomerResponse response = new GetCustomerResponse();
        response.setCustomer(customer);
        return ResponseEntity.ok(response);
    }

    @PutMapping(
            path = "{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<Void> updateCustomer(@RequestBody UpdateCustomerRequest updateCustomerRequest){
        customerService.updateCustomer(updateCustomerRequest);
        System.out.println("Customer updated"+updateCustomerRequest.getUpdatedName());
        System.out.println("Customer updated"+updateCustomerRequest.getUpdatedIsActive());
        return ResponseEntity.noContent().build();// it will return 204 No Content

    }


    @DeleteMapping(
            path="{id}"
    )
    public ResponseEntity<String> deleteCustomer(@RequestBody DeleteCustomerRequest deleteCustomerRequest){
        logger.info("delete customer request called for id : "+deleteCustomerRequest.getId());
        customerService.deleteCustomer(deleteCustomerRequest);
        return ResponseEntity.ok("customer deleted with userId: "+deleteCustomerRequest.getId());
    }

//
//
////
////
////
////
////    }
   }