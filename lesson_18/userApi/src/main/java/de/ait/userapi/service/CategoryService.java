package de.ait.userapi.service;

import de.ait.userapi.dto.CategoryRequestDto;
import de.ait.userapi.dto.CategoryResponseDto;
import de.ait.userapi.dto.ProductRequestDto;
import de.ait.userapi.dto.ProductResponseDto;

import java.util.List;

public interface CategoryService {
    List<CategoryResponseDto> getCategories();
    CategoryResponseDto getCategoryById(Long id);
    CategoryResponseDto save(CategoryRequestDto dto);
}
