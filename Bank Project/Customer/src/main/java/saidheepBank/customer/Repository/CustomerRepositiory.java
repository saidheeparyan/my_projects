package saidheepBank.customer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import saidheepBank.customer.model.Customer;

@Repository
public interface CustomerRepositiory extends JpaRepository<Customer,Long>{
    
}
