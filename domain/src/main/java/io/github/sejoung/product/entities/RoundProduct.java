package io.github.sejoung.product.entities;



import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class RoundProduct extends Product {

    @Min(1)
    @Max(99)
    private Integer count;

    public RoundProduct(Long productId, Long categoryId, Category.ProductType productType, ProductStatus status,
        String productName, Integer count) {
        super(productId, new Category(categoryId, productType), status, productName);
        this.count = count;
        validateSelf();
    }

    public void update(ProductStatus status, Integer count) {
        setStatus(status);
        this.count = count;
    }
}
