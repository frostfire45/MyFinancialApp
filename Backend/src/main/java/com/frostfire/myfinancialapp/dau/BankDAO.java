package com.frostfire.myfinancialapp.dau;
import com.frostfire.myfinancialapp.model.Bank;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BankDAO extends CrudRepository<Bank,Long> {
    List<Bank> getAllBanks();
    void addNewBank(Bank bank);
    void deleteBank(int id);
    void updateBank(Bank bank);
}