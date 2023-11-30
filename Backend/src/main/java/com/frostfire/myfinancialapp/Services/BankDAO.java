package com.frostfire.myfinancialapp.services;

import com.frostfire.myfinancialapp.Models.Bank;

import java.util.List;

public interface BankDAO {
    List<Bank> getAllBanks();
    void addNewBank();
    void deleteBank();
    void updateBank(Bank bank);
}
