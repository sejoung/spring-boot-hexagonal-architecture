package io.github.sejoung.product.usecases.port.in;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import io.github.sejoung.product.entities.Category;
import io.github.sejoung.product.entities.Product;
import io.github.sejoung.product.validating.SelfValidating;

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
