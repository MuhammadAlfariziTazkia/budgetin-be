package com.alfarizi.budgetin.service.intr;

import com.alfarizi.budgetin.dto.CategoryRequestDto;
import com.alfarizi.budgetin.exception.CategoryHaveTransactionsException;
import com.alfarizi.budgetin.exception.EntityNotFoundException;
import com.alfarizi.budgetin.model.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryService {

    Category create (CategoryRequestDto requestDto);

    List<Category> getAll();

    Category getById (UUID id) throws EntityNotFoundException;

    List<Category> getByYearAndMonth(Integer year, Integer month);

    void delete (UUID id) throws EntityNotFoundException, CategoryHaveTransactionsException;

    Category update (UUID id, CategoryRequestDto requestDto) throws EntityNotFoundException;
}
