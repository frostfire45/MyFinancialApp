package com.frostfire.myfinancialapp.Services;

import com.frostfire.myfinancialapp.Models.AccountType;
import com.frostfire.myfinancialapp.Models.Bank;
import com.frostfire.myfinancialapp.dau.BankDAO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MockBank implements BankDAO {
    Bank bank1 = new Bank(1,"Chase", "87783291-229332-218", AccountType.CHECKING, "5543");
    Bank bank2 = new Bank(2,"RBFCU", "87783291-229218", AccountType.SAVINGS, "44322");

    public MockBank(){}
    @Override
    public List<Bank> getAllBanks() {
        List<Bank> banks = new ArrayList<>();
        banks.add(bank1);
        banks.add(bank2);
        return banks;
    }

    @Override
    public void addNewBank() {

    }

    @Override
    public void deleteBank() {

    }

    @Override
    public void updateBank(Bank bank) {

    }
}
