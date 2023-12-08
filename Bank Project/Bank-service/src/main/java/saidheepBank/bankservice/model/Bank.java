package saidheepBank.bankservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bank {

    @Id
    long bank_id;
    long AC_number;
    String bank_name;
    long balance;
    String account_type;
}