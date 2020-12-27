package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ua.lviv.iot.dataaccess.CustomerRepository;
import ua.lviv.iot.model.Customer;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerService {

  @Autowired
  private CustomerRepository customerRepository;

  public List<Customer> getAllCustomers() {
    return customerRepository.findAll();
  }

  public Customer getCustomerById(Integer customerId) {
    if (customerRepository.existsById(customerId)) {
      return customerRepository.findById(customerId).get();
    }
    return null;
  }

  @Transactional
  public Customer createCustomer(Customer customer) {
    return customerRepository.save(customer);
  }

  @Transactional
  public ResponseEntity<Customer> deleteCustomer(Integer customerId) {
    if (customerRepository.existsById(customerId)) {
      customerRepository.deleteById(customerId);
      return ResponseEntity.ok().build();
    }
    return ResponseEntity.notFound().build();
  }

  @Transactional
  public ResponseEntity<Customer> updateCustomer(Customer customer, Integer customerId) {
    if (customerRepository.existsById(customerId)) {
      return ResponseEntity.ok(customerRepository.save(customer));
    }
    return ResponseEntity.notFound().build();
  }
}
