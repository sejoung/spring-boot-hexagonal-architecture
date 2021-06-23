package io.github.sejoung.product.rest.constants;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import io.github.sejoung.product.entities.Category;

class ProductTypeTest {

    @Test
    void valueOf() {
        var actal = ProductType.valueOf(Category.ProductType.ROUND.name());

        assertThat(actal).isNotNull();
    }
}