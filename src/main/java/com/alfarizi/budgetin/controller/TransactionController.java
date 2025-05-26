package com.alfarizi.budgetin.controller;

import com.alfarizi.budgetin.dto.BaseResponseDto;
import com.alfarizi.budgetin.dto.TransactionRequestDto;
import com.alfarizi.budgetin.exception.EntityNotFoundException;
import com.alfarizi.budgetin.service.intr.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static com.alfarizi.budgetin.constant.Path.ID;
import static com.alfarizi.budgetin.constant.Path.TRANSACTION_PATH;
import static com.alfarizi.budgetin.utils.ResponseUtil.notFound;
import static com.alfarizi.budgetin.utils.ResponseUtil.success;

@RestController
@RequestMapping(TRANSACTION_PATH)
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<BaseResponseDto> insert (@RequestBody TransactionRequestDto requestDto) {
        return success(transactionService.insert(requestDto));
    }

    @GetMapping
    public ResponseEntity<BaseResponseDto> getAll (
            @RequestParam(value = "year", required = false) Integer year,
            @RequestParam(value = "month", required = false) Integer month
    ) {
    return success(transactionService.get(year, month));
    }

    @PutMapping(ID)
    public ResponseEntity<BaseResponseDto> update (
            @PathVariable("id") UUID id,
            @RequestBody TransactionRequestDto requestDto
            ) {
        try {
            return success(transactionService.update(id, requestDto));
        } catch (EntityNotFoundException e) {
            return notFound(e);
        }
    }

    @DeleteMapping(ID)
    public ResponseEntity<BaseResponseDto> delete (@PathVariable("id") UUID id) {
        try {
            transactionService.delete(id);
            return success();
        } catch (EntityNotFoundException e) {
            return notFound(e);
        }
    }

    @GetMapping(ID)
    public ResponseEntity<BaseResponseDto> getById (@PathVariable("id") UUID id) {
        try {
            return success(transactionService.getById(id));
        } catch (EntityNotFoundException e) {
            return notFound(e);
        }
    }
}
