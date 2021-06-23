package io.github.sejoung.product.persistence.service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import io.github.sejoung.product.persistence.repository.ProductRepository;
import io.github.sejoung.product.persistence.util.JpaTestUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@DataJpaTest
class JPASaveRoundProductServiceTest {
    @Autowired
    private ProductRepository repository;

    private JPASaveRoundProductService service;

    @BeforeEach
    void setUp() {
        service = new JPASaveRoundProductService(repository);
    }

    @Test
    void saveRoundProduct() {
        var actual = service.saveRoundProduct(JpaTestUtil.defaultRoundProduct());
        log.debug("{}", actual);
        assertThat(actual.getProductId()).isNotNull();

    }
}