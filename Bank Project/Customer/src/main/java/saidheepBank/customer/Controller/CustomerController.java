package saidheepBank.customer.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import saidheepBank.customer.Service.CustomerService;
import saidheepBank.customer.model.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/save")
    public ResponseEntity<Customer> save(@RequestBody Customer customer){
        return customerService.save(customer);
    }

    @PostMapping("/saveall")
    public ResponseEntity<List<Customer>> saveall(@RequestBody List<Customer> customer){
        return customerService.saveall(customer);
    }

    @GetMapping("/getcustomer")
    public ResponseEntity<Customer> getCustomer(@RequestParam("id") long id) {
        return customerService.getcustomerid(id);
    }

    @GetMapping("/findbalance")
    public ResponseEntity<String> getBalance(@RequestParam("id") long id){
        return customerService.getbalance(id);
    }
    
}