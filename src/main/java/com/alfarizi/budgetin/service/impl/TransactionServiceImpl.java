package com.alfarizi.budgetin.service.impl;

import com.alfarizi.budgetin.dto.TransactionRequestDto;
import com.alfarizi.budgetin.exception.EntityNotFoundException;
import com.alfarizi.budgetin.model.Category;
import com.alfarizi.budgetin.model.Transaction;
import com.alfarizi.budgetin.repository.TransactionRepository;
import com.alfarizi.budgetin.service.intr.TransactionService;
import com.alfarizi.budgetin.service.intr.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static com.alfarizi.budgetin.constant.Entity.TRANSACTION;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserService userService;

    @Override
    public Transaction insert(TransactionRequestDto requestDto) {
        Transaction transaction = new Transaction();
        transaction.setAmount(requestDto.getAmount());
        transaction.setCategory(new Category(requestDto.getCategoryId()));
        transaction.setDate(requestDto.getDate());
        transaction.setDescription(requestDto.getDescription());
        return transactionRepository.save(transaction);
    }

    @Override
    public List<Transaction> get (Integer year, Integer month) {
        return transactionRepository.findByUserIdAndYearAndMonth(userService.getAuthenticatedUser().getId(), year, month);
    }

    @Override
    public Transaction getById(UUID id) throws EntityNotFoundException {
        return transactionRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(TRANSACTION, id));
    }

    @Override
    public Transaction update(UUID id, TransactionRequestDto requestDto) throws EntityNotFoundException {
        Transaction transaction = getById(id);
        transaction.setDescription(requestDto.getDescription());
        transaction.setDate(requestDto.getDate());
        transaction.setCategory(new Category(requestDto.getCategoryId()));
        transaction.setAmount(requestDto.getAmount());
        return transactionRepository.save(transaction);
    }

    @Override
    public void delete(UUID id) throws EntityNotFoundException {
        Transaction transaction = getById(id);
        transactionRepository.delete(transaction);
    }
}
