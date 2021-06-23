package io.github.sejoung.product.usecases.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.github.sejoung.product.entities.Product;
import io.github.sejoung.product.usecases.port.in.SaveRoundProductInUseCase;
import io.github.sejoung.product.usecases.port.out.SaveRoundProductOutUseCaseStub;

class DomainSaveRoundProductServiceTest {
    private DomainSaveRoundProductService service;

    @BeforeEach
    void setUp() {
        this.service = new DomainSaveRoundProductService(new SaveRoundProductOutUseCaseStub());
    }

    @DisplayName("회차권 저장")
    @Test
    void saveTest() {
        var command = SaveRoundProductInUseCase.SaveRoundProductCommand.builder()
            .productName("회차권")
            .count(99)
            .categoryId(1L)
            .status(Product.ProductStatus.CREATE)
            .build();
        var actual = service.save(command);
        Assertions.assertEquals(99, actual.getProductId());
    }
}