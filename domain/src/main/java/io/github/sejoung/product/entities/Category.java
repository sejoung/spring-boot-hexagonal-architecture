package io.github.sejoung.product.entities;

import jakarta.validation.constraints.NotNull;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Category {
    public enum ProductType {
        ROUND, PERIOD
    }

    @NotNull
    private final Long categoryId;

    @NotNull
    private final ProductType productType;

    public Category(Long categoryId, ProductType productType) {
        this.categoryId = categoryId;
        this.productType = productType;
    }
}
