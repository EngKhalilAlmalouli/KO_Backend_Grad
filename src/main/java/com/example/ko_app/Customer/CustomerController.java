//package com.example.KO_Recycle_App.Customer;
//
//import com.example.KO_Recycle_App.Configruration.NotFoundInDatabaseException;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/customers")
//@RequiredArgsConstructor
//public class CustomerController {
//    private final CustomerService customerService;
//
//    @GetMapping
//    public ResponseEntity<List<?>> getAllCustomers() {
//        return ResponseEntity.ok(customerService.getAllCustomers());
//    }
//    @GetMapping("/{id}")
//    public CustomerResponse getCustomerById(@PathVariable int id) {
//        return customerService.getCustomerById(id);
//    }
//    @PostMapping
//    public CustomerResponse createCustomer(@RequestBody CustomerRequest request) {
//        return customerService.createCustomer(request);
//    }
//    @PutMapping("/{id}")
//    public CustomerResponse updateCustomer(@PathVariable Integer id, @RequestBody CustomerRequest request) {
//        return customerService.updateCustomer(id, request);
//    }
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> deleteCustomer(@PathVariable Integer id) throws NotFoundInDatabaseException {
//        return customerService.deleteCustomer(id);
//    }
//
//}


package com.example.ko_app.Customer;

import com.example.ko_app.Configruration.NotFoundInDatabaseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerService customerService;

    // Constructor for dependency injection
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<List<?>> getAllCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @GetMapping("/{id}")
    public CustomerResponse getCustomerById(@PathVariable int id) {
        return customerService.getCustomerById(id);
    }

    @PostMapping
    public CustomerResponse createCustomer(@RequestBody CustomerRequest request) {
        return customerService.createCustomer(request);
    }

    @PutMapping("/{id}")
    public CustomerResponse updateCustomer(@PathVariable Integer id, @RequestBody CustomerRequest request) {
        return customerService.updateCustomer(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Integer id) throws NotFoundInDatabaseException {
        return customerService.deleteCustomer(id);
    }
}

