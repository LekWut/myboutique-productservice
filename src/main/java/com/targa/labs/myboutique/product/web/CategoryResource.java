package com.targa.labs.myboutique.product.web;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.targa.labs.myboutique.common.dto.CategoryDto;
import com.targa.labs.myboutique.product.service.CategoryService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/categories")
public class CategoryResource {
	private final CategoryService categoryService;

	@GetMapping
	public List<CategoryDto> findAll() {
		return this.categoryService.findAll();
	}

	@GetMapping("/{id}")
	public CategoryDto findById(@PathVariable Long id) {
		return this.categoryService.findById(id);
	}

	@PostMapping
	public CategoryDto create(CategoryDto categoryDto) {
		return this.categoryService.create(categoryDto);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		this.categoryService.delete(id);
	}
}
