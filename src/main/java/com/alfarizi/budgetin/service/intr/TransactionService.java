package com.alfarizi.budgetin.service.intr;

import com.alfarizi.budgetin.dto.TransactionDto;
import com.alfarizi.budgetin.dto.TransactionRequestDto;
import com.alfarizi.budgetin.exception.EntityNotFoundException;
import com.alfarizi.budgetin.model.Transaction;

import java.util.List;
import java.util.UUID;

public interface TransactionService {

    Transaction insert (TransactionRequestDto requestDto);

    List<Transaction> get (Integer year, Integer month);

    Transaction getById (UUID id) throws EntityNotFoundException;

    Transaction update (UUID id, TransactionRequestDto requestDto) throws EntityNotFoundException;

    void delete (UUID id) throws EntityNotFoundException;
}
