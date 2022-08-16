package com.example.bank.service;

import com.example.bank.model.TransferBalance;
import com.example.bank.repository.BalanceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class BankService {

    private final BalanceRepository balanceRepository;                          //инжектим бин BalanceRepository

//    public BankService(BalanceRepository balanceRepository) {                //вместо конструктора ставим аннотацию @AllArgsConstructor от Lombok
//        this.balanceRepository = balanceRepository;
//    }

    public BigDecimal getBalance(Long accountId) {                           //метод получения баланса по id
        BigDecimal balance = balanceRepository.getBalanceForId(accountId);
        if (balance == null){
            throw new IllegalArgumentException("Баланс равен нулю");
        }
        return balance;
    }

    public BigDecimal addMoney(Long to, BigDecimal amount) {                  //метод пополнения счета
        return null;
    }

    public void makeTransfer(TransferBalance transferBalance) {               //метод для перевода денег

    }
}
