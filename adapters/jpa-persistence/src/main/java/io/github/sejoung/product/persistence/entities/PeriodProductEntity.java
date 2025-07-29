package io.github.sejoung.product.persistence.entities;

import io.github.sejoung.product.persistence.constants.ProductStatus;
import io.github.sejoung.product.persistence.constants.ProductType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@ToString(callSuper = true)
@DiscriminatorValue(PeriodProductEntity.DISCRIMINATOR_VALUE)
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PeriodProductEntity extends ProductEntity {
    public static final String DISCRIMINATOR_VALUE = "PERIOD";

    @Column
    private LocalDate startDate;

    @Column
    private LocalDate endDate;

    public PeriodProductEntity(String productName, Long categoryId, ProductStatus productStatus, LocalDate startDate,
        LocalDate endDate) {
        super(productName, ProductType.PERIOD, categoryId, productStatus);
        this.startDate = startDate;
        this.endDate = endDate;
    }
}