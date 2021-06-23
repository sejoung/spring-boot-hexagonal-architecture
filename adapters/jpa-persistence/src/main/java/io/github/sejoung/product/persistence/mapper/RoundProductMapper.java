package io.github.sejoung.product.persistence.mapper;

import io.github.sejoung.product.entities.Category;
import io.github.sejoung.product.entities.Product;
import io.github.sejoung.product.entities.RoundProduct;

import io.github.sejoung.product.persistence.constants.ProductStatus;
import io.github.sejoung.product.persistence.entities.RoundProductEntity;

public interface RoundProductMapper {

    static RoundProductEntity toEntity(RoundProduct product) {
        return new RoundProductEntity(product.getProductName(), product.getCategory().getCategoryId(),
            ProductStatus.valueOf(product.getStatus().name()),
            product.getCount());
    }
    static RoundProduct toDto(RoundProductEntity entity) {
        return new RoundProduct(entity.getProductId(), entity.getCategoryId(),
            Category.ProductType.valueOf(entity.getProductType().name()),
            Product.ProductStatus.valueOf(entity.getProductStatus().name()), entity.getProductName(),
            entity.getCount());

    }

}
