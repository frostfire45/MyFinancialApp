package com.frostfire.myfinancialapp.Services;

import java.util.List;

import com.frostfire.myfinancialapp.model.Bank;

public interface BankService {
    List<Bank> queryByName(String bankName);
    Bank queryById(int id);
    List<Bank> getAllBanks();
    void addNewBank(Bank bank);
    void updateBank(Bank bank);
    void deleteBank(int id);
}
