package io.github.sejoung.product.usecases.port.out;

import io.github.sejoung.product.entities.RoundProduct;

public class SaveRoundProductOutUseCaseStub implements SaveRoundProductOutUseCase {

    @Override
    public RoundProduct saveRoundProduct(
        RoundProduct product) {
        return new RoundProduct(99L, product.getCategory().getCategoryId(), product.getCategory().getProductType(),
            product.getStatus(), product.getProductName(), product.getCount());
    }
}