package io.github.sejoung.product.rest.util;

import io.github.sejoung.product.usecases.port.in.SaveRoundProductInUseCase;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SaveRoundProductInUseCaseStub implements SaveRoundProductInUseCase {
    @Override
    public SaveRoundProductCommand save(SaveRoundProductCommand command) {
        log.debug("{}", command);
        return SaveRoundProductCommand.builder()
            .categoryId(command.getCategoryId())
            .productName(command.getProductName())
            .productId(1L)
            .status(command.getStatus())
            .count(command.getCount())
            .build();
    }
}
