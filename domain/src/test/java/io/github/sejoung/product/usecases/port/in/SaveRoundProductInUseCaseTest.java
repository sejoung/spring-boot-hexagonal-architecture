package io.github.sejoung.product.usecases.port.in;

import static org.junit.jupiter.api.Assertions.*;

import javax.validation.ConstraintViolationException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.github.sejoung.product.entities.Category;
import io.github.sejoung.product.entities.Product;

class SaveRoundProductInUseCaseTest {

    @DisplayName("Commend 회차권 count는 99 이하여야 합니다")
    @Test
    void validationSaveRoundProductCommand() {

        Throwable exception = assertThrows(ConstraintViolationException.class, () -> {
            SaveRoundProductInUseCase.SaveRoundProductCommand.builder()
                .categoryId(1L)
                .status(Product.ProductStatus.CREATE)
                .productName("안녕")
                .count(999)
                .build();

        });

        assertEquals("count: 99 이하여야 합니다", exception.getMessage());

    }
}