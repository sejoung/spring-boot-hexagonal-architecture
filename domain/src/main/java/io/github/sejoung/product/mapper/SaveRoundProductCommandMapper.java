package io.github.sejoung.product.mapper;

import io.github.sejoung.product.entities.RoundProduct;
import io.github.sejoung.product.usecases.port.in.SaveRoundProductInUseCase;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public abstract class SaveRoundProductCommandMapper {

    public static SaveRoundProductInUseCase.SaveRoundProductCommand toDto(RoundProduct roundProduct) {

        return new SaveRoundProductInUseCase.SaveRoundProductCommand(roundProduct.getProductId(),
            roundProduct.getCategory().getCategoryId(), roundProduct.getCategory().getProductType(),
            roundProduct.getStatus(), roundProduct.getProductName(), roundProduct.getCount());
    }

    public static RoundProduct toEntity(SaveRoundProductInUseCase.SaveRoundProductCommand command) {
        return new RoundProduct(command.getProductId(), command.getCategoryId(), command.getProductType(),
            command.getStatus(), command.getProductName(), command.getCount());
    }
}
