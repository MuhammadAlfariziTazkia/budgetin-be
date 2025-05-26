package com.alfarizi.budgetin.controller;

import com.alfarizi.budgetin.dto.BaseResponseDto;
import com.alfarizi.budgetin.dto.CategoryRequestDto;
import com.alfarizi.budgetin.exception.CategoryHaveTransactionsException;
import com.alfarizi.budgetin.exception.EntityNotFoundException;
import com.alfarizi.budgetin.service.intr.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.UUID;

import static com.alfarizi.budgetin.constant.Path.CATEGORY_PATH;
import static com.alfarizi.budgetin.constant.Path.ID;
import static com.alfarizi.budgetin.utils.ResponseUtil.*;


@RestController
@RequestMapping(CATEGORY_PATH)
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<BaseResponseDto> create (@RequestBody CategoryRequestDto requestDto) {
        return success(categoryService.create(requestDto));
    }

    @GetMapping
    public ResponseEntity<BaseResponseDto> getAll (
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) Integer month
    ) {
        System.out.println("LALALAA");
        return (Objects.nonNull(year) && Objects.nonNull(month))
                ? success(categoryService.getByYearAndMonth(year, month))
                : success(categoryService.getAll());
    }

    @PutMapping(ID)
    public ResponseEntity<BaseResponseDto> update (@PathVariable("id") UUID id, @RequestBody CategoryRequestDto categoryRequestDto) {
        try {
            return success(categoryService.update(id, categoryRequestDto));
        } catch (EntityNotFoundException e) {
            return notFound(e);
        }
    }

    @DeleteMapping(ID)
    public ResponseEntity<BaseResponseDto> delete (@PathVariable("id")UUID id) {
        try {
            categoryService.delete(id);
            return success();
        } catch (EntityNotFoundException e) {
            return notFound(e);
        } catch (CategoryHaveTransactionsException e) {
            return unprocessableEntity(e);
        }
    }

    @GetMapping(ID)
    public ResponseEntity<BaseResponseDto> getById (@PathVariable("id") UUID id) {
        try {
            return success(categoryService.getById(id));
        } catch (EntityNotFoundException e) {
            return notFound(e);
        }
    }
}
