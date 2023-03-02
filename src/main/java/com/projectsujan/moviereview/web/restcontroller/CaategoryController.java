package com.projectsujan.moviereview.web.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projectsujan.moviereview.service.CategoryService;
import com.projectsujan.moviereview.web.dto.CategoryDto;

@RestController
@RequestMapping("/api/moviereview")
public class CaategoryController {

	@Autowired
	private CategoryService categoryService;

	@PostMapping("category/create")
	public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto) {

		CategoryDto createdCategory = this.categoryService.createCategory(categoryDto);

		return new ResponseEntity<CategoryDto>(createdCategory, HttpStatus.CREATED);
	}

	@GetMapping("/category/{id}")
	public ResponseEntity<CategoryDto> getCategory(@PathVariable Long id) {
		CategoryDto category = this.categoryService.getCategoryById(id);
		return new ResponseEntity<CategoryDto>(category, HttpStatus.OK);

	}

	@GetMapping("/category/list")
	public ResponseEntity<List<CategoryDto>> getAllCategories() {
		List<CategoryDto> categotyList = this.categoryService.getAllCategory();
		return new ResponseEntity<List<CategoryDto>>(categotyList, HttpStatus.OK);
	}

	@PutMapping("category/update")
	public ResponseEntity<CategoryDto> updateCategory(@RequestParam Long id, @RequestBody CategoryDto categoryDto) {

		CategoryDto updatedCategory = this.categoryService.updateCategory(id, categoryDto);

		return new ResponseEntity<CategoryDto>(updatedCategory, HttpStatus.OK);

	}

	@DeleteMapping("/category/delete")
	public ResponseEntity<String> deleteCategory(@RequestParam Long id) {
		this.categoryService.deleteCategory(id);
		return new ResponseEntity<String>("Category Deletion Sucessfull !!", HttpStatus.OK);
	}

}
