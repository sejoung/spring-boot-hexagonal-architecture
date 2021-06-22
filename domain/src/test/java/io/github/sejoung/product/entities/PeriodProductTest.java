package io.github.sejoung.product.entities;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import jakarta.validation.ConstraintViolationException;

class PeriodProductTest {

    @DisplayName("startDate는 값이 있어야 됩니다.")
    @Test
    void startDateValidate() {
        Throwable exception = assertThrows(ConstraintViolationException.class, () -> {
            new PeriodProduct(null, 1L, Category.ProductType.PERIOD, Product.ProductStatus.TEMPORARY, "기간권", null,
                LocalDate.now().plusDays(1));
        });
        assertEquals("startDate: 널이어서는 안됩니다", exception.getMessage());

    }
}