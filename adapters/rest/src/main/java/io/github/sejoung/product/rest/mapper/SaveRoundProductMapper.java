package io.github.sejoung.product.rest.mapper;

import io.github.sejoung.product.entities.Product;
import io.github.sejoung.product.rest.constants.ProductStatus;
import io.github.sejoung.product.rest.constants.ProductType;
import io.github.sejoung.product.rest.dto.SaveRoundProduct;
import io.github.sejoung.product.usecases.port.in.SaveRoundProductInUseCase;

public interface SaveRoundProductMapper {
    static SaveRoundProductInUseCase.SaveRoundProductCommand toEntity(SaveRoundProduct dto) {
        return SaveRoundProductInUseCase.SaveRoundProductCommand.builder()
            .productName(dto.getProductName())
            .categoryId(dto.getCategoryId())
            .productId(dto.getProductId())
            .status(Product.ProductStatus.valueOf(dto.getStatus().name()))
            .count(dto.getCount())
            .build();
    }

    static SaveRoundProduct toDto(SaveRoundProductInUseCase.SaveRoundProductCommand command) {
        return SaveRoundProduct.builder()
            .productType(ProductType.valueOf(command.getProductType().name()))
            .productId(command.getProductId())
            .productName(command.getProductName())
            .categoryId(command.getCategoryId())
            .status(ProductStatus.valueOf(command.getStatus().name()))
            .count(command.getCount())
            .build();
    }
}
