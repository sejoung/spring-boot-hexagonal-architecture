package io.github.sejoung.product.usecases.port.in;


import io.github.sejoung.product.entities.Category;
import io.github.sejoung.product.entities.Product;
import io.github.sejoung.product.validating.SelfValidating;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

public interface SaveRoundProductInUseCase {

    SaveRoundProductCommand save(SaveRoundProductCommand command);

    @Getter
    @ToString
    @EqualsAndHashCode(callSuper = false)
    final class SaveRoundProductCommand extends SelfValidating<SaveRoundProductCommand> {

        private final Long productId;

        @NotNull
        private final Long categoryId;

        @NotNull
        private final Category.ProductType productType;

        @NotNull
        private final Product.ProductStatus status;

        @NotEmpty
        private final String productName;

        @Min(1)
        @Max(99)
        private final Integer count;

        @Builder
        private SaveRoundProductCommand(Long productId, Long categoryId,
            Product.ProductStatus status, String productName, Integer count) {
            this.productId = productId;
            this.categoryId = categoryId;
            this.productType = Category.ProductType.ROUND;
            this.status = status;
            this.productName = productName;
            this.count = count;
            this.validateSelf();
        }
    }
}