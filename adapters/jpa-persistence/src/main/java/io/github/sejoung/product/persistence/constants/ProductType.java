package io.github.sejoung.product.persistence.constants;


import io.github.sejoung.product.persistence.entities.PeriodProductEntity;
import io.github.sejoung.product.persistence.entities.RoundProductEntity;
import lombok.Getter;

@Getter
public enum ProductType {
    ROUND(RoundProductEntity.DISCRIMINATOR_VALUE), PERIOD(PeriodProductEntity.DISCRIMINATOR_VALUE);
    private final String value;

    ProductType(String value) {
        this.value = value;
    }
}
