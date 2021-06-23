package io.github.sejoung.product.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.sejoung.product.persistence.entities.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
