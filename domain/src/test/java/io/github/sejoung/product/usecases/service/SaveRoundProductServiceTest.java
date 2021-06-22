package io.github.sejoung.product.usecases.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.github.sejoung.product.entities.Category;
import io.github.sejoung.product.entities.Product;
import io.github.sejoung.product.usecases.port.in.SaveRoundProductInUseCase;
import io.github.sejoung.product.usecases.port.out.SaveRoundProductOutUseCaseStub;

class SaveRoundProductServiceTest {

    private SaveRoundProductService service;

    @BeforeEach
    void setUp() {
        this.service = new SaveRoundProductService(new SaveRoundProductOutUseCaseStub());
    }

    @DisplayName("회차권 저장")
    @Test
    void saveTest() {
        var command = new SaveRoundProductInUseCase.SaveRoundProductCommand(null, 1L, Category.ProductType.ROUND,
            Product.ProductStatus.CREATE, "2회권", 2);
        var actual = service.save(command);
        assertEquals(99, actual.getProductId());
    }
}