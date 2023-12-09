package com.frostfire.myfinancialapp.Controller;

import com.frostfire.myfinancialapp.Services.BankService;
import com.frostfire.myfinancialapp.model.Bank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BankController {

    @Autowired
    private BankService bankService;

    final String REDIRECT_BANK_QUERY = "redirect:/bank/bankQuery";

    // GET All
    @RequestMapping(value = REDIRECT_BANK_QUERY, method = RequestMethod.GET)
    public ModelAndView showAllBanks() {
        ModelAndView mnv = new ModelAndView();
        mnv.setViewName(REDIRECT_BANK_QUERY);
        // Refactor so that I only need to call it once
        if (!bankService.getAllBanks().isEmpty()) {
            mnv.addObject("banks", bankService.getAllBanks());
        }
        return mnv;
    }

    // CREATE GET
    @RequestMapping(value = "/bank/addNewBank", method = RequestMethod.GET)
    public ModelAndView addBankGet(){
        return new ModelAndView("/bank/add_new_bank_form");
    }

    // CREATE POST
    @RequestMapping(value = "/bank/addNewBank", method = RequestMethod.POST)
    public String addBankGet(@ModelAttribute("bankAddForm") Bank bankPostVal){
        if( bankPostVal.getId() >=0
                && !bankPostVal.getBankName().isEmpty()
                && !bankPostVal.getAccountNumber().isEmpty()
                && !bankPostVal.getType().name().isEmpty()
                && !Double.toString(bankPostVal.getBalance()).isEmpty()){

            int count = bankService.getAllBanks().size() + 1;
            bankService.addNewBank(new Bank(count, bankPostVal.getBankName(),bankPostVal.getAccountNumber(), bankPostVal.getType(),bankPostVal.getBalance()));
        }
        return REDIRECT_BANK_QUERY;
    }

    // UPDATE GET
    @RequestMapping(value = "/bank/updateBank/{id}", method = RequestMethod.GET)
    public ModelAndView updateBankGet(@PathVariable("id") int id){
        System.out.println(id);
        Bank bank = bankService.queryById(id);
        ModelAndView mnv = new ModelAndView();
        mnv.setViewName("/bank/updateBankForm");
        mnv.addObject("bank",bank);
        return mnv;
    }

    // UPDATE POST
    @PostMapping(value="/bank/updateBank")
    public String updateBankPost(@ModelAttribute("bankUpdateForm") Bank bankPostVal) {
        if( bankPostVal.getId() >=0
                && !bankPostVal.getBankName().isEmpty()
                && !bankPostVal.getAccountNumber().isEmpty()
                && !bankPostVal.getType().name().isEmpty()
                && !Double.toString(bankPostVal.getBalance()).isEmpty()){
            Bank bank = bankService.queryById(bankPostVal.getId());
            bank.setBankName(bankPostVal.getBankName());
            bank.setBalance(bankPostVal.getBalance());
            bank.setAccountNumber(bankPostVal.getAccountNumber());
            bankService.updateBank(bank);
        }
        return REDIRECT_BANK_QUERY;
    }
    // DELETE
    @RequestMapping(value = "/bank/deleteBank/{id}", method = RequestMethod.GET)
    public String deleteBankGet(@PathVariable("id") int id) {
        if(id >= 0){
            bankService.deleteBank(id);
        }
        return REDIRECT_BANK_QUERY;
    }
}
