package com.frostfire.myfinancialapp.Services;


import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.frostfire.myfinancialapp.dau.BankDAO;

import com.frostfire.myfinancialapp.model.Bank;
import org.springframework.transaction.annotation.Transactional;


public class BankServicesImp_old implements BankService {
    
    //Autowired
    private BankDAO bankDAO;

    @Override
    @Transactional
    public List<Bank> getAllBanks() {
        //(a,b) -> Integer.compare(a.getId(),b.getId())
        //List<Bank> filter_banks = bankDAO.getAllBanks().sort();
        return bankDAO.getAllBanks();
    }
    @Override
    @Transactional
    public List<Bank> queryByName(String bankName) {
        List<Bank> allBanks = bankDAO.getAllBanks();
        List<Bank> bankList = allBanks.stream()
                .filter(bank -> Objects.equals(bank.getBankName(), bankName))
                .collect(Collectors.toList());
        return bankList;
    }
    @Override
    public Bank queryById(int id) {
        List<Bank> bankList = bankDAO.getAllBanks();
        // I will need to make this better
        if(id >= 0 && id < bankList.size()) {
            return bankList.get(id);
        }
        return null;
    }


    @Override
    public void addNewBank(Bank bank) {
        bankDAO.addNewBank(bank);
        //this.mochBanks.add(bank);
    }

    @Override
    public void updateBank(Bank bank) {
        bankDAO.updateBank(bank);//.set(bank.getId(),bank);
    }

    @Override
    public void deleteBank(int id) {
        // Put in logic to pull once for stuff like size, but for now leave
        List<Bank> bankList = bankDAO.getAllBanks();
        if(id >= 0 && id < bankList.size()) {
            bankDAO.deleteBank(id);
            //this.mochBanks.removeIf(t -> t.getId() == id);
        }
    }
}
