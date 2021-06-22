package io.github.sejoung.product.usecases.port.in;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.github.sejoung.product.entities.Category;
import io.github.sejoung.product.entities.Product;
import jakarta.validation.ConstraintViolationException;

class SaveRoundProductInUseCaseTest {

    @DisplayName("Commend 회차권 count는 99 이하여야 합니다")
    @Test
    void validationSaveRoundProductCommand() {

        Throwable exception = assertThrows(ConstraintViolationException.class, () -> {
            var command = new SaveRoundProductInUseCase.SaveRoundProductCommand(null, 1L, Category.ProductType.ROUND,
                Product.ProductStatus.CREATE, "2회권", 999);
        });

        assertEquals("count: 99 이하여야 합니다", exception.getMessage());

    }
}