package io.github.sejoung.product.rest.dto;



import io.github.sejoung.product.rest.constants.ProductStatus;
import io.github.sejoung.product.rest.constants.ProductType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class SaveRoundProduct {

    private final Long productId;

    @NotNull
    private final Long categoryId;

    @NotNull
    private final ProductType productType;

    @NotNull
    private final ProductStatus status;

    @NotEmpty
    private final String productName;

    @Min(1)
    @Max(99)
    private final Integer count;

    @Builder
    private SaveRoundProduct(Long productId, Long categoryId,
        ProductType productType, ProductStatus status, String productName, Integer count) {
        this.productId = productId;
        this.categoryId = categoryId;
        this.productType = productType;
        this.status = status;
        this.productName = productName;
        this.count = count;
    }
}