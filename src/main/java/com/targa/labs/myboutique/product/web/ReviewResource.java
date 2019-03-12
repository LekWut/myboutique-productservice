package com.targa.labs.myboutique.product.web;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.targa.labs.myboutique.common.dto.ReviewDto;
import com.targa.labs.myboutique.product.service.ReviewService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/reviews")
public class ReviewResource {
	private final ReviewService reviewService;

	@GetMapping
	public List<ReviewDto> findAll() {
		return this.reviewService.findAll();
	}

	@GetMapping("/{id}")
	public ReviewDto findById(@PathVariable Long id) {
		return this.reviewService.findById(id);
	}

	@PostMapping
	public ReviewDto create(@RequestBody ReviewDto reviewDto) {
		return this.reviewService.create(reviewDto);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		this.reviewService.delete(id);
	}
}
