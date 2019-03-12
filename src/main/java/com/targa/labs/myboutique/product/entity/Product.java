package com.targa.labs.myboutique.product.entity;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.targa.labs.myboutique.common.entity.AbstractEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "product")
public class Product extends AbstractEntity {
	@NotNull
	@Column(name = "name", nullable = false)
	private String name;
	@NotNull
	@Column(name = "description", nullable = false)
	private String description;
	@NotNull
	@Column(name = "price", precision = 10, scale = 2, nullable = false)
	private BigDecimal price;
	@Column(name = "quantity")
	private Integer quantity;
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable = false)
	private ProductStatus status;
	@Column(name = "sales_counter")
	private Integer salesCounter;
	@OneToMany
	private Set<Review> reviews = new HashSet<>();
	@ManyToOne
	private Category category;
}
