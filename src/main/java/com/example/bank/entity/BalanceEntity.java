package com.example.bank.entity;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
public class BalanceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "balance")
    private BigDecimal balance = new BigDecimal(0);
}
