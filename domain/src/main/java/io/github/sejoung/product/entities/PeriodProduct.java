package io.github.sejoung.product.entities;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class PeriodProduct extends Product {
    @NotNull
    private final LocalDate startDate;
    @NotNull
    private final LocalDate endDate;

    public PeriodProduct(Long productId, Long categoryId, Category.ProductType productType,
        ProductStatus status, String productName, LocalDate startDate, LocalDate endDate) {
        super(productId, new Category(categoryId, productType), status, productName);
        this.startDate = startDate;
        this.endDate = endDate;
        validateSelf();
    }
}
