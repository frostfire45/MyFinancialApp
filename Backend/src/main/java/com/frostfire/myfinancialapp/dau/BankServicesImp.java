package com.frostfire.myfinancialapp.dau;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.frostfire.myfinancialapp.Services.BankService;
import org.springframework.stereotype.Service;

import com.frostfire.myfinancialapp.model.Bank;

@Service
public class BankServicesImp implements BankService {
    
    private final List<Bank> mochBanks = new ArrayList<>();;

    public BankServicesImp(){
        loadPreData();
    }
    private void loadPreData(){
        Bank bank1 = new Bank();
        bank1.setId(3);
        bank1.setBankName("RBFCU");
        bank1.setAccountNumber("3321223");
        bank1.setType(Bank.AccountType.Checking);
        bank1.setBalance(3322.33);
        this.mochBanks.add(bank1);

        this.mochBanks.add(
                new Bank(
                0,
                "Chase",
                "88332-22334-2221-2212",
                Bank.AccountType.Checking,
                3245.22));
        this.mochBanks.add(new Bank(
                1,
                "Chase",
                "4421-4566-77821-1231",
                Bank.AccountType.Savings,
                32443));
    }
    @Override
    public List<Bank> queryByName(String bankName) {
        return this.mochBanks.stream()
            .filter(bank -> Objects.equals(bank.getBankName(), bankName))
            .collect(Collectors.toList());
    }
    @Override
    public Bank queryById(int id) {
        if(id >= 0 && id < mochBanks.size()) {
            return mochBanks.get(id);
        }
        return null;
    }
    @Override
    public List<Bank> getAllBanks() {
        this.mochBanks.sort((a,b) -> Integer.compare(a.getId(),b.getId()));
        return this.mochBanks;
    }

    @Override
    public void addNewBank(Bank bank) {
        this.mochBanks.add(bank);
    }

    @Override
    public void updateBank(Bank bank) {
        mochBanks.set(bank.getId(),bank);
    }

    @Override
    public void deleteBank(int id) {
        if(id >= 0 && id < mochBanks.size()) {
            this.mochBanks.removeIf(t -> t.getId() == id);
        }
    }
}
