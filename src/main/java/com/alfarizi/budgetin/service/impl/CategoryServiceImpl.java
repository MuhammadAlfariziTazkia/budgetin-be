package com.alfarizi.budgetin.service.impl;

import com.alfarizi.budgetin.dto.CategoryRequestDto;
import com.alfarizi.budgetin.exception.CategoryHaveTransactionsException;
import com.alfarizi.budgetin.exception.EntityNotFoundException;
import com.alfarizi.budgetin.model.Category;
import com.alfarizi.budgetin.repository.CategoryRepository;
import com.alfarizi.budgetin.service.intr.CategoryService;
import com.alfarizi.budgetin.service.intr.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.UUID;

import static com.alfarizi.budgetin.constant.Entity.CATEGORY;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserService userService;

    @Override
    public Category create(CategoryRequestDto requestDto) {
        Category category = new Category();
        category.setName(requestDto.getName());
        category.setBudgetAmount(requestDto.getBudgetAmount());
        category.setUserId(userService.getAuthenticatedUser().getId());
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findByUserId(userService.getAuthenticatedUser().getId());
    }

    @Override
    public Category getById(UUID id) throws EntityNotFoundException {
        return categoryRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(CATEGORY, id));
    }

    @Override
    public List<Category> getByYearAndMonth(Integer year, Integer month) {
            return categoryRepository.findCategoriesWithRemainingAmount(userService.getAuthenticatedUser().getId(), year, month);
    }

    @Override
    public void delete(UUID id) throws EntityNotFoundException, CategoryHaveTransactionsException {
        Category category = getById(id);
        if (!ObjectUtils.isEmpty(category.getTransactions())) throw new CategoryHaveTransactionsException(id);
        categoryRepository.delete(category);
    }

    @Override
    public Category update(UUID id, CategoryRequestDto requestDto) throws EntityNotFoundException {
        Category category = getById(id);
        category.setName(requestDto.getName());
        category.setBudgetAmount(requestDto.getBudgetAmount());
        return categoryRepository.save(category);
    }
}
