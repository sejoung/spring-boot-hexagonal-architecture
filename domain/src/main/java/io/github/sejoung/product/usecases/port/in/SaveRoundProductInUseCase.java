package io.github.sejoung.product.usecases.port.in;

import io.github.sejoung.product.entities.Category;
import io.github.sejoung.product.entities.Product;
import io.github.sejoung.product.validating.SelfValidating;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;

public interface SaveRoundProductInUseCase {

    SaveRoundProductCommand save(SaveRoundProductCommand command);

    @Getter
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

        public SaveRoundProductCommand(Long productId, Long categoryId, Category.ProductType productType,
            Product.ProductStatus status, String productName, Integer count) {
            this.productId = productId;
            this.categoryId = categoryId;
            this.productType = productType;
            this.status = status;
            this.productName = productName;
            this.count = count;
            this.validateSelf();
        }
    }
}
