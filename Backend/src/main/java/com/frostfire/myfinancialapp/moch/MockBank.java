package com.frostfire.myfinancialapp.moch;

import com.frostfire.myfinancialapp.model.Bank;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MockBank  {
    //Bank bank1 = new Bank(1,"Chase", "87783291-229332-218", AccountType.CHECKING, "5543");
    //Bank bank2 = new Bank(2,"RBFCU", "87783291-229218", AccountType.SAVINGS, "44322");

    public MockBank(){}

    public List<Bank> getAllBanks() {
        List<Bank> banks = new ArrayList<>();
        //banks.add(bank1);
        //banks.add(bank2);
        return banks;
    }


    public void addNewBank() {

    }


    public void deleteBank() {

    }


    public void updateBank(Bank bank) {

    }
}
