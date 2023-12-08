package saidheepBank.customer.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import saidheepBank.customer.Repository.CustomerRepositiory;
import saidheepBank.customer.client.BankClient;
import saidheepBank.customer.model.Customer;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepositiory customerRepositiory;

    @Autowired
    private BankClient bankClient;

    public ResponseEntity<Customer> save(Customer customer) {

        customer.setBank_id(bankClient.getbyid(customer.getCustomer_id()).getBank_id());

        return new ResponseEntity<>(customerRepositiory.save(customer),HttpStatus.CREATED);
    }

    public ResponseEntity<List<Customer>> saveall(List<Customer> customer) {

        for(int i=0; i<customer.size();i++){
         customer.get(i).setBank_id(bankClient.getall().get(i).getBank_id());
        }
        
        return new ResponseEntity<>(customerRepositiory.saveAll(customer),HttpStatus.CREATED);
    }

    public ResponseEntity<Customer> getcustomerid(long id) {
        return new ResponseEntity<>(customerRepositiory.findById(id).get(),HttpStatus.OK);
    }

    public ResponseEntity<String> getbalance(long id) {
        return bankClient.getbalanceid(id);
    }

}
