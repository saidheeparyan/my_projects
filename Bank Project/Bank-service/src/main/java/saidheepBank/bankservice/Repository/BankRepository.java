package saidheepBank.bankservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import saidheepBank.bankservice.model.Bank;

@Repository
public interface BankRepository  extends JpaRepository<Bank,Long>{
}
