package com.example.bank.repository;

import com.example.bank.entity.BalanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Repository
public interface BalanceRepository extends JpaRepository<BalanceEntity, Long> {
    public final Map<Long, BigDecimal> storage = new HashMap<>();  //создаем хранилице счетов


    public default BigDecimal getBalanceForId(Long accountId) {
        return storage.get(accountId);
    }
}
