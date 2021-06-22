package io.github.sejoung.product.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString(callSuper = true)
@DiscriminatorValue(PeriodProductEntity.DISCRIMINATOR_VALUE)
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PeriodProductEntity extends ProductEntity{
    public static final String DISCRIMINATOR_VALUE = "PERIOD";

}
