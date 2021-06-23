package io.github.sejoung.product.mapper;

import io.github.sejoung.product.entities.Product;
import io.github.sejoung.product.entities.RoundProduct;
import io.github.sejoung.product.usecases.port.in.SaveRoundProductInUseCase;

public interface SaveRoundProductCommandMapper {

    static SaveRoundProductInUseCase.SaveRoundProductCommand toDto(RoundProduct roundProduct) {
        return SaveRoundProductInUseCase.SaveRoundProductCommand.builder()
            .productName(roundProduct.getProductName())
            .productId(roundProduct.getProductId())
            .status(
                Product.ProductStatus.valueOf(roundProduct.getStatus().name()))
            .categoryId(roundProduct.getCategory().getCategoryId())
            .count(roundProduct.getCount())
            .build();
    }

    static RoundProduct toEntity(SaveRoundProductInUseCase.SaveRoundProductCommand command) {
        return new RoundProduct(command.getProductId(), command.getCategoryId(), command.getProductType(),
            command.getStatus(), command.getProductName(), command.getCount());
    }
}
