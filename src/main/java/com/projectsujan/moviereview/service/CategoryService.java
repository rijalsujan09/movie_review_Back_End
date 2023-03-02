package com.projectsujan.moviereview.service;

import java.util.List;

import com.projectsujan.moviereview.web.dto.CategoryDto;

public interface CategoryService {

	public CategoryDto createCategory(CategoryDto categoryDto);

	public CategoryDto getCategoryById(Long id);

	public CategoryDto updateCategory(Long id, CategoryDto categoryDto);

	public List<CategoryDto> getAllCategory();

	void deleteCategory(Long id);

}
