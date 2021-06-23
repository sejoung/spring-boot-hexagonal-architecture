package io.github.sejoung.product.persistence.service;

import javax.transaction.Transactional;

import io.github.sejoung.product.entities.RoundProduct;

import io.github.sejoung.product.persistence.mapper.RoundProductMapper;
import io.github.sejoung.product.persistence.repository.ProductRepository;
import io.github.sejoung.product.usecases.port.out.SaveRoundProductOutUseCase;

public class JPASaveRoundProductService implements SaveRoundProductOutUseCase {

    private final ProductRepository repository;

    public JPASaveRoundProductService(ProductRepository repository) {
        this.repository = repository;
    }

    @Transactional
    @Override
    public RoundProduct saveRoundProduct(RoundProduct product) {
        var productEntity = RoundProductMapper.toEntity(product);
        return RoundProductMapper.toDto(repository.save(productEntity));
    }
}
