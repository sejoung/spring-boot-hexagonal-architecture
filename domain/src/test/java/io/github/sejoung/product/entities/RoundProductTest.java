package io.github.sejoung.product.entities;

import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;



class RoundProductTest {

    @DisplayName("count 최소 값은 1 이상입니다.")
    @Test
    void countValidate() {
        Throwable exception = assertThrows(ConstraintViolationException.class, () -> {
            new RoundProduct(null, 1L, Category.ProductType.ROUND, Product.ProductStatus.CREATE, "회차권", 0);
        });
        assertEquals("count: 1 이상이어야 합니다", exception.getMessage());
    }
}