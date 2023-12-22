package com.frostfire.myfinancialapp.Services;

import com.frostfire.myfinancialapp.dau.BankDAO;
import com.frostfire.myfinancialapp.model.Bank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BankServiceImp implements BankService{
    @Autowired
    private BankDAO bankDao;

    @Transactional
    public List<Bank> queryByName(String bankName) {
        return null;
    }

    @Transactional
    public Bank queryById(int id) {
        return null;
    }

    @Transactional(readOnly = true)
    public List<Bank> getAllBanks() {
        List<Bank> bnk = bankDao.getAllBanks();
        return bankDao.getAllBanks();
    }

    @Transactional
    public void addNewBank(Bank bank) {
        bankDao.addNewBank(bank);
    }

    @Transactional
    public void updateBank(Bank bank) {

    }

    @Transactional
    public void deleteBank(int id) {

    }
}
