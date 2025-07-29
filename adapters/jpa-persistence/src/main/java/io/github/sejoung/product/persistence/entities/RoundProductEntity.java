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

@ToString(callSuper = true)
@DiscriminatorValue(RoundProductEntity.DISCRIMINATOR_VALUE)
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RoundProductEntity extends ProductEntity {
    public static final String DISCRIMINATOR_VALUE = "ROUND";

    @Column(name = "cnt", nullable = false)
    private Integer count;

    public RoundProductEntity(String productName,
        Long categoryId, ProductStatus productStatus, Integer count) {
        super(productName, ProductType.ROUND, categoryId, productStatus);
        this.count = count;
    }
}