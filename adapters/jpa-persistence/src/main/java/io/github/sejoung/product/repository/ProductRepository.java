package io.github.sejoung.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.sejoung.product.entities.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
