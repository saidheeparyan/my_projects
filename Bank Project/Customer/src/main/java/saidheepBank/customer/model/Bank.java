package saidheepBank.customer.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bank {

    long bank_id;
    long AC_number;
    String bank_name;
    long balance;
    String account_type;
}