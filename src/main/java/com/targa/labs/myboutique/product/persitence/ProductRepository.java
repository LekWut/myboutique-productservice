package com.targa.labs.myboutique.product.persitence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.targa.labs.myboutique.product.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}