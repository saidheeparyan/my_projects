package saidheepBank.bankservice.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import saidheepBank.bankservice.Repository.BankRepository;
import saidheepBank.bankservice.model.Bank;

@Service
public class BankService {

    @Autowired
    private BankRepository bankRepository;

    public Bank saveBank(Bank bank) {

        return bankRepository.save(bank);
    }

    public List<Bank> saveBankall(List<Bank> bank) {

        return bankRepository.saveAll(bank);
    }

    public Bank getbyid(long id) {
        return bankRepository.findById(id).get();
    }

    public ResponseEntity<String> getbalancebyid(long id) {
        Bank b=bankRepository.findById(id).get();
        return new ResponseEntity<>("Your balance is"+b.getBalance(),HttpStatus.OK);
    }

    public ResponseEntity<String> deposit(long id,long amount) {

        Bank b= bankRepository.findById(id).get();
        b.setBalance(b.getBalance()+amount);
        bankRepository.save(b);
        return new ResponseEntity<>("Money deposited succesfully", HttpStatus.OK);
    }

    public ResponseEntity<String> withdraw(long id,long amount) {

        Bank b= bankRepository.findById(id).get();
        b.setBalance(b.getBalance()-amount);
        bankRepository.save(b);
        return new ResponseEntity<>("Money deposited succesfully", HttpStatus.OK);
    }

    public ResponseEntity<String> close(long id) {
        bankRepository.deleteById(id);

        return new ResponseEntity<>("Account closed successfully",HttpStatus.GONE);
    }

    public List<Bank> getall() {
        return bankRepository.findAll();
    }

}
