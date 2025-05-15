//package com.example.KO_Recycle_App.Customer;
//
//import com.example.KO_Recycle_App.Configruration.NotFoundInDatabaseException;
//import com.example.KO_Recycle_App.validation.ObjectValidator;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//@RequiredArgsConstructor
//public class CustomerService {
//    private final CustomerRepository customerRepository;
//    private final ObjectValidator<CustomerRequest> validator;
//
//    public List<?> getAllCustomers() {
//        return customerRepository.findAll().stream().map(this:: mapToResponse).collect(Collectors.toList());
//    }
//
////    getCustomerByID
//    public CustomerResponse getCustomerById(Integer id) {
//        return customerRepository.findById(id)
//                .map(this:: mapToResponse)
//                .orElseThrow(() -> new RuntimeException("Customer not found"));
//    }
//
//
////    createCustomer
//    public CustomerResponse createCustomer(CustomerRequest request) {
//        validator.validate(request);
//        Customer customer = Customer.builder()
//                .firstName(request.getFirstName())
//                .lastName(request.getLastName())
//                .userName(request.getUserName())
//                .address(request.getAddress())
//                .phone(request.getPhone())
//                .email(request.getEmail())
//                .password(request.getPassword())
//                .image(request.getImage())
//                .build();
//        customerRepository.save(customer);
//        return mapToResponse(customer);
//
//    }
//    //updateCustomer
//public CustomerResponse updateCustomer(Integer id, CustomerRequest request) {
//    Customer customer = customerRepository.findById(id)
//            .orElseThrow(() -> new RuntimeException("Customer not found"));
//    validator.validate(request);
//    customer.setFirstName(request.getFirstName());
//    customer.setLastName(request.getLastName());
//    customer.setUserName(request.getUserName());
//    customer.setAddress(request.getAddress());
//    customer.setPhone(request.getPhone());
//    customer.setEmail(request.getEmail());
//    customer.setPassword(request.getPassword());
//    customer.setImage(request.getImage());
//
//    customer = customerRepository.save(customer);
//    return mapToResponse(customer);
//}
//
//    //deleteCustomer
//    public ResponseEntity<?> deleteCustomer(Integer id) throws NotFoundInDatabaseException {
//        Customer customer = customerRepository.findById(id)
//                .orElseThrow(() -> new NotFoundInDatabaseException("Customer not found"));
//
//
//        return ResponseEntity.status(HttpStatus.OK).body("Customer deleted successfully");
//    }
//
////    mapToResponse
//private CustomerResponse mapToResponse(Customer customer) {
//        List<Integer> customerIds = new ArrayList<>();
//        return CustomerResponse.builder()
//                .username(customer.getUserName())
//                .firstName(customer.getFirstName())
//                .lastName(customer.getLastName())
//                .address(customer.getAddress())
//                .phoneNumber(customer.getPhone())
//                .email(customer.getEmail())
//                .password(customer.getPassword())
//                .image(customer.getImage())
//                .build();
//}
//}


package com.example.ko_app.Customer;

import com.example.ko_app.Configruration.NotFoundInDatabaseException;
import com.example.ko_app.validation.ObjectValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final ObjectValidator<CustomerRequest> validator;

    // Constructor for dependency injection
    public CustomerService(CustomerRepository customerRepository, ObjectValidator<CustomerRequest> validator) {
        this.customerRepository = customerRepository;
        this.validator = validator;
    }

    public List<?> getAllCustomers() {
        return customerRepository.findAll().stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    // getCustomerByID
    public CustomerResponse getCustomerById(Integer id) {
        return customerRepository.findById(id)
                .map(this::mapToResponse)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    // createCustomer
    public CustomerResponse createCustomer(CustomerRequest request) {
        validator.validate(request);
        Customer customer = new Customer();
        customer.setFirstName(request.getFirstName());
        customer.setLastName(request.getLastName());
        customer.setUserName(request.getUserName());
        customer.setAddress(request.getAddress());
        customer.setPhone(request.getPhone());
        customer.setEmail(request.getEmail());
        customer.setPassword(request.getPassword());
        customer.setImage(request.getImage());

        customerRepository.save(customer);
        return mapToResponse(customer);


    }

    // updateCustomer
    public CustomerResponse updateCustomer(Integer id, CustomerRequest request) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        validator.validate(request);

        customer.setFirstName(request.getFirstName());
        customer.setLastName(request.getLastName());
        customer.setUserName(request.getUserName());
        customer.setAddress(request.getAddress());
        customer.setPhone(request.getPhone());
        customer.setEmail(request.getEmail());
        customer.setPassword(request.getPassword());
        customer.setImage(request.getImage());


        customer = customerRepository.save(customer);
        return mapToResponse(customer);
    }

    // deleteCustomer
    public ResponseEntity<?> deleteCustomer(Integer id) throws NotFoundInDatabaseException {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new NotFoundInDatabaseException("Customer not found"));

        customerRepository.delete(customer); // Ensure the customer is actually deleted
        return ResponseEntity.status(HttpStatus.OK).body("Customer deleted successfully");
    }

    // mapToResponse
    private CustomerResponse mapToResponse(Customer customer) {
        List<Integer> customerIds = new ArrayList<>();
        CustomerResponse response = new CustomerResponse();
        response.setCustomerId(customer.getId());
        response.setUsername(customer.getUserName());
        response.setFirstName(customer.getFirstName());
        response.setLastName(customer.getLastName());
        response.setAddress(customer.getAddress());
        response.setPhoneNumber(customer.getPhone());
        response.setEmail(customer.getEmail());
        response.setPassword(customer.getPassword());
        response.setImage(customer.getImage());


        return response;
    }
}

