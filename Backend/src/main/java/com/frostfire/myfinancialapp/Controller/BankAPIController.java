package com.frostfire.myfinancialapp.Controller;

import com.frostfire.myfinancialapp.Services.BankService;
import com.frostfire.myfinancialapp.model.Bank;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class BankAPIController {
    @Autowired
    private BankService bankService;

    @GetMapping(path = "/getAllRecord", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> sayHello(){
        List<JSONObject> entities = new ArrayList<JSONObject>();

        JSONObject entity = null;
        // When making a call to a service make a new object.
        for (Bank bank : bankService.getAllBanks()){
            entity = new JSONObject();
            entity.put("Id",String.valueOf(bank.getId()));
            entity.put("BankName", bank.getBankName());
            entity.put("AccountNumber", bank.getAccountNumber());
            entity.put("AccountType", bank.getType().name());
            entity.put("Balance", String.valueOf(bank.getBalance()));
            entities.add(entity);
        }
        return new ResponseEntity<Object>(entities.toString(), HttpStatus.OK);
    }
    @RequestMapping(value = "/addBank", method = RequestMethod.POST)
    public HttpStatus addBank(
            @RequestParam("bankName") String bankName,
            @RequestParam("accountNumber") String accountNumber,
            @RequestParam("accountType") Bank.AccountType type,
            @RequestParam("accountBalance") Double balance){

        int count = bankService.getAllBanks().size() + 1;
        bankService.addNewBank(new Bank(count,bankName,accountNumber,type,balance));
        return HttpStatus.CREATED;
    }

    @PostMapping(value = "/updateBank")
    public HttpStatus updateBank(@RequestBody Bank bank){

        return HttpStatus.OK;
    }
    /*
    (
            @RequestParam("id") int id,
            @RequestParam("bankName") String bankName,
            @RequestParam("accountNumber") String accountNumber,
            @RequestParam("accountType") Bank.AccountType type,
            @RequestParam("accountBalance") Double balance)

    @RequestMapping(value = "/updateBank", method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus updateBank(@RequestBody Bank bank) {
        if( bank.getId() >=0 ){
            if(!bankService.queryById(id).isEmpty()) {
                if (!bank.getBankName().isEmpty() && !bank.getBankName().isEmpty() && !bank.getType().name().isEmpty() && bank.getBalance() != 0.0) {
                    Bank bank = bankService.queryById(id).get(0);
                    bank.setBankName(bankName);
                    bank.setBalance(balance);
                    bank.setAccountNumber(accountNumber);
                    bankService.updateBank(bank);
                    System.out.println("Hit");
                }
                else {
                    return HttpStatus.NOT_FOUND;
                }
            }
        }
        else {
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.OK;
    }
     */

    // DELETE
    @RequestMapping(value = "/deleteBank", method = RequestMethod.GET)
    public HttpStatus deleteBank(@RequestParam("Id") int id) {

        if(id >= 0){
            if( bankService.queryById(id) != null  ) {
                bankService.deleteBank(id);
            }
            else {
                return HttpStatus.BAD_REQUEST;
            }
        }
        else {
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.OK;
    }
}
