package com.alfarizi.budgetin.repository;

import com.alfarizi.budgetin.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface TransactionRepository extends JpaRepository<Transaction, UUID> {

    @Query("SELECT t FROM Transaction t " +
            "LEFT JOIN FETCH t.category tc " +
            "WHERE tc.userId = :userId " +
            "AND (:year IS null OR YEAR(t.date) = :year) " +
            "AND (:month IS null OR MONTH(t.date) = :month)")
    List<Transaction> findByUserIdAndYearAndMonth (
            @Param("userId") UUID userId,
            @Param("year") Integer year,
            @Param("month") Integer month);
}
