package com.targa.labs.myboutique.product.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.targa.labs.myboutique.common.dto.ProductDto;
import com.targa.labs.myboutique.product.entity.Product;
import com.targa.labs.myboutique.product.entity.ProductStatus;
import com.targa.labs.myboutique.product.persitence.CategoryRepository;
import com.targa.labs.myboutique.product.persitence.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
@Transactional
public class ProductService {
	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;

	public List<ProductDto> findAll() {
		log.debug("Request to get all Products");
		return this.productRepository.findAll().stream().map(ProductService::mapToDto).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public ProductDto findById(Long id) {
		log.debug("Request to get Product : {}", id);
		return this.productRepository.findById(id).map(ProductService::mapToDto).orElse(null);
	}

	public ProductDto create(ProductDto productDto) {
		log.debug("Request to create Product : {}", productDto);
		return mapToDto(
				this.productRepository.save(
					new Product(
							productDto.getName(), 
							productDto.getDescription(),
							productDto.getPrice(), 
							productDto.getQuantity(), 
							ProductStatus.valueOf(productDto.getStatus()),
							productDto.getSalesCounter(), 
							null,
							this.categoryRepository.
								findById(productDto.getCategory().getId()).orElse(null))));
	}

	public void delete(Long id) {
		log.debug("Request to delete Product : {}", id);
		this.productRepository.deleteById(id);
	}

	public static ProductDto mapToDto(Product product) {
		if (product != null) {
			return new ProductDto(product.getId(), product.getName(), product.getDescription(), product.getPrice(),
					product.getQuantity(), product.getStatus().name(), product.getSalesCounter(),
					product.getReviews().stream().map(ReviewService::mapToDto).collect(Collectors.toSet()),
					CategoryService.mapToDto(product.getCategory()));
		}
		return null;
	}
}
