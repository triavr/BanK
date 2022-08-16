package com.example.bank.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransferBalance {

    private Long from;    // поле: от кого был перевод
    private Long to;    // поле: кому был перевод
    private BigDecimal amount;    // поле: какая сумма
}
