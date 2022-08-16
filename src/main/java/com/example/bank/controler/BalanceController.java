package com.example.bank.controler;


import com.example.bank.model.TransferBalance;
import com.example.bank.service.BankService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Slf4j                              //добавляем в класс логгер log
@RestController("/balance")
@AllArgsConstructor
public class BalanceController {                                    // отвечает за получение баланса счета и за пополнение счета

    private final BankService bankService;                          //инжектим бин BankService

//    public BalanceController(BankService bankService) {            //вместо конструктора ставим аннотацию @AllArgsConstructor от Lombok
//        this.bankService = bankService;
//    }

    @GetMapping("/{accountId}")
    public BigDecimal getBalance(@PathVariable Long accountId) {           //метод получения баланса

       return bankService.getBalance(accountId);
    }

    @PostMapping("/add")                                        //метод пополнения счета
    public BigDecimal addMoney(@RequestBody TransferBalance transferBalance) {

        return bankService.addMoney(transferBalance.getTo(), transferBalance.getAmount());
    }

    @PostMapping("/transfer")                                        //метод для перевода денег
    public void transfer(@RequestBody TransferBalance transferBalance) {
              bankService.makeTransfer(transferBalance);
    }


//    @ExceptionHandler(IllegalAccessException.class)
//    public String handle(IllegalAccessException e) {
//        log.error(e.getMessage());
//        return "Данный аккаунт не создан";
//    }
}
