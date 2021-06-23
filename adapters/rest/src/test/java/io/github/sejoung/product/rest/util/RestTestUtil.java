package io.github.sejoung.product.rest.util;

import io.github.sejoung.product.entities.Product;
import io.github.sejoung.product.usecases.port.in.SaveRoundProductInUseCase;

public interface RestTestUtil {

    static SaveRoundProductInUseCase.SaveRoundProductCommand defaultSaveRoundProductCommand(Long productId) {
        return SaveRoundProductInUseCase.SaveRoundProductCommand.builder()
            .count(1)
            .status(Product.ProductStatus.CREATE)
            .productId(productId)
            .productName("회차권")
            .categoryId(1L)
            .build();
    }

}
