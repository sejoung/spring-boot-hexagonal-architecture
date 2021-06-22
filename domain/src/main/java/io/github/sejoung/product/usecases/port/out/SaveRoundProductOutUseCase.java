package io.github.sejoung.product.usecases.port.out;

import io.github.sejoung.product.entities.RoundProduct;

public interface SaveRoundProductOutUseCase {
    RoundProduct saveRoundProduct(RoundProduct product);
}
