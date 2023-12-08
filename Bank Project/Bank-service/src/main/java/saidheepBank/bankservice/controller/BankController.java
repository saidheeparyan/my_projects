package saidheepBank.bankservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import saidheepBank.bankservice.Service.BankService;
import saidheepBank.bankservice.model.Bank;

@RestController
@RequestMapping("/bank")
public class BankController {

    @Autowired
    private BankService bankservice;

    @PostMapping("/save")
    public Bank saveBank(@RequestBody Bank bank){

        return bankservice.saveBank(bank);

    }

    @PostMapping("/saveall")
    public List<Bank> saveBank(@RequestBody List<Bank> bank){

        return bankservice.saveBankall(bank);

    }
    @GetMapping("/bankdetails")
    public Bank getbyid(@RequestParam("id") long id){
        return bankservice.getbyid(id);
    }

    @GetMapping("/getall")
    public List<Bank> getall(){
        return bankservice.getall();
    }

    @GetMapping("/getbalance")
    public ResponseEntity<String> getbalanceid(@RequestParam("id")long id){
        return bankservice.getbalancebyid(id);
    }


    @PutMapping("/deposit")
    public ResponseEntity<String> deposit(@RequestParam("id") long id,@RequestParam("amount") long amount){
        
        return bankservice.deposit(id,amount);
    }

    @PutMapping("/withdraw")
    public ResponseEntity<String> withdraw(@RequestParam("id") long id,@RequestParam("amount") long amount){
        
        return bankservice.withdraw(id,amount);
    }

    @DeleteMapping("/close")
    public ResponseEntity<String> closeAccount(@RequestParam("id")long id){

        return bankservice.close(id);
    }

    
}
