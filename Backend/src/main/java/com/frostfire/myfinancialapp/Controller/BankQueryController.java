package com.frostfire.myfinancialapp.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.frostfire.myfinancialapp.Services.BankService;
import com.frostfire.myfinancialapp.model.Bank;

@Controller
//@RequestMapping("/bank/bankQuery")
public class BankQueryController {
    @Autowired
    private BankService bankService;

    @GetMapping
    public ModelAndView setupForm() {
        ModelAndView mnv = new ModelAndView();
        mnv.setViewName("/bank/bankQuery");
        if (!bankService.getAllBanks().isEmpty()) {
            mnv.addObject("banks", bankService.getAllBanks());
        }
        return mnv;
    }
    @PostMapping
    public ModelAndView submitForm(
        @RequestParam("bankName") String bankName, Model model)
        {
            List<Bank> banks = java.util.Collections.emptyList();
            if(bankName != null){
                banks = bankService.queryByName(bankName);
            }
            model.addAttribute("banks", banks);
            ModelAndView mnv = new ModelAndView();
            mnv.setViewName("/bank/bankQuery");
            mnv.addObject("banks",banks);
            return mnv;
        }
}
