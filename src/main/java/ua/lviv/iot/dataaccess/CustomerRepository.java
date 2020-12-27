package ua.lviv.iot.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.iot.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
