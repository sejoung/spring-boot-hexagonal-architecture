package io.github.sejoung.product.constants;

import io.github.sejoung.product.entities.PeriodProductEntity;
import io.github.sejoung.product.entities.RoundProductEntity;
import lombok.Getter;

@Getter
public enum ProductType {
    ROUND(RoundProductEntity.DISCRIMINATOR_VALUE), PERIOD(PeriodProductEntity.DISCRIMINATOR_VALUE);
    private final String value;

    ProductType(String value) {
        this.value = value;
    }
}
