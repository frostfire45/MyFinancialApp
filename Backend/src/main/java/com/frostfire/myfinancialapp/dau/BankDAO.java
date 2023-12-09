package com.frostfire.myfinancialapp.dau;
import com.frostfire.myfinancialapp.model.Bank;
import java.util.List;

public interface BankDAO {
    List<Bank> getAllBanks();
    void addNewBank(Bank bank);
    void deleteBank(int id);
    void updateBank(Bank bank);
}
