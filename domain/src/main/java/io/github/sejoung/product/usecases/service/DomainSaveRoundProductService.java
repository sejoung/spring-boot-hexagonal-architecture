package io.github.sejoung.product.usecases.service;

import io.github.sejoung.product.mapper.SaveRoundProductCommandMapper;
import io.github.sejoung.product.usecases.port.in.SaveRoundProductInUseCase;
import io.github.sejoung.product.usecases.port.out.SaveRoundProductOutUseCase;

public class DomainSaveRoundProductService implements SaveRoundProductInUseCase {

    private final SaveRoundProductOutUseCase saveRoundProductOutUseCase;

    public DomainSaveRoundProductService(SaveRoundProductOutUseCase saveRoundProductOutUseCase) {
        this.saveRoundProductOutUseCase = saveRoundProductOutUseCase;
    }

    @Override
    public SaveRoundProductCommand save(SaveRoundProductCommand command) {

        var roundProduct = saveRoundProductOutUseCase.saveRoundProduct(SaveRoundProductCommandMapper.toEntity(command));
        return SaveRoundProductCommandMapper.toDto(roundProduct);
    }
}
