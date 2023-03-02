package com.projectsujan.moviereview.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectsujan.moviereview.entity.Category;
import com.projectsujan.moviereview.exception.ResourceNotFoundException;
import com.projectsujan.moviereview.repository.CategoryRepository;
import com.projectsujan.moviereview.service.CategoryService;
import com.projectsujan.moviereview.web.dto.CategoryDto;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {

		Category category = this.modelMapper.map(categoryDto, Category.class);

		Category savedCategory = this.categoryRepository.save(category);

		return this.modelMapper.map(savedCategory, CategoryDto.class);
	}

	@Override
	public CategoryDto getCategoryById(Long id) {

		Category category = this.categoryRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User", "User_Id", id));

		CategoryDto categoryDto = this.modelMapper.map(category, CategoryDto.class);

		return categoryDto;
	}

	@Override
	public CategoryDto updateCategory(Long id, CategoryDto categoryDto) {

		Category category = this.categoryRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "Category_Id", id));

		category.setCategoryDescription(categoryDto.getCategoryDescription());
		category.setCategoryTitle(categoryDto.getCategoryTitle());

		Category updatedCategory = this.categoryRepository.save(category);

		return this.modelMapper.map(updatedCategory, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getAllCategory() {

		List<Category> category = this.categoryRepository.findAll();

		List<CategoryDto> categorylist = category.stream().map((cat) -> this.modelMapper.map(cat, CategoryDto.class))
				.collect(Collectors.toList());

		return categorylist;
	}

	@Override
	public void deleteCategory(Long id) {
		Category category = this.categoryRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "Category_Id", id));
		this.categoryRepository.delete(category);
	}

}
