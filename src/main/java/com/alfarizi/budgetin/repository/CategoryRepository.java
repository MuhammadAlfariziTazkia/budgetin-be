package com.alfarizi.budgetin.repository;

import com.alfarizi.budgetin.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {

    @Query("SELECT new com.alfarizi.budgetin.model.Category(" +
            "c.id, c.name, c.budgetAmount, (c.budgetAmount - COALESCE(SUM(t.amount), 0))) " +
            "FROM Category c " +
            "LEFT JOIN c.transactions t " +
            "ON (:year IS NULL OR EXTRACT(YEAR FROM t.date) = :year) " +
            "AND (:month IS NULL OR EXTRACT(MONTH FROM t.date) = :month) " +
            "GROUP BY c " +
            "HAVING c.userId = :userId")
    List<Category> findCategoriesWithRemainingAmount(
            @Param("userId") UUID userId,
            @Param("year") Integer year,
            @Param("month") Integer month);

    @Query("SELECT c FROM Category c WHERE c.userId = :userId")
    List<Category> findByUserId(@Param("userId") UUID userId);

}
