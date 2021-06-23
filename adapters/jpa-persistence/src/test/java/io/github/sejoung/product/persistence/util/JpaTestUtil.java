package io.github.sejoung.product.persistence.util;

import io.github.sejoung.product.entities.Category;
import io.github.sejoung.product.entities.Product;
import io.github.sejoung.product.entities.RoundProduct;

public interface JpaTestUtil {
    static RoundProduct defaultRoundProduct() {
        return new RoundProduct(null, 1L, Category.ProductType.ROUND, Product.ProductStatus.CREATE, "회차권", 2);
    }
}
