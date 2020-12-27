package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.model.Customer;
import ua.lviv.iot.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

  @Autowired
  private CustomerService customerService;

  @GetMapping(value = "/{id}")
  public Customer getCustomer(@PathVariable("id") Integer customerId) {
    return customerService.getCustomerById(customerId);
  }

  @GetMapping
  public List<Customer> getAllCustomers() {
    return customerService.getAllCustomers();
  }

  @PostMapping
  public Customer addCustomer(final @RequestBody Customer customer) {
    return customerService.createCustomer(customer);
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<Customer> updateCustomer(final @RequestBody Customer customer,
                                                 @PathVariable("id") Integer customerId) {
    customer.setId(customerId);
    return customerService.updateCustomer(customer, customerId);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") Integer customerId) {
    return customerService.deleteCustomer(customerId);
  }
}
