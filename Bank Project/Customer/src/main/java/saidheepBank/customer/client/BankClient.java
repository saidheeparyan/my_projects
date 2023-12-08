package saidheepBank.customer.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import saidheepBank.customer.model.Bank;

@Component
@FeignClient("BANK-SERVICE")
public interface BankClient {
     @PostMapping("/bank/save")
    public Bank saveBank(@RequestBody Bank bank);

    @PostMapping("/bank/saveall")
    public List<Bank> saveBank(@RequestBody List<Bank> bank);

    @GetMapping("/bank/bankdetails")
    public Bank getbyid(@RequestParam("id") long id);

    @GetMapping("/bank/getall")
    public List<Bank> getall();

    @GetMapping("/bank/getbalance")
    public ResponseEntity<String> getbalanceid(@RequestParam("id") long id);


    @PutMapping("/bank/deposit")
    public ResponseEntity<String> deposit(@RequestParam("id") long id,@RequestParam("amount") long amount);


    @PutMapping("/bank/withdraw")
    public ResponseEntity<String> withdraw(@RequestParam("id") long id,@RequestParam("amount") long amount);

    @DeleteMapping("/bank/close")
    public ResponseEntity<String> closeAccount(@RequestParam("id")long id);
}