package io.github.sejoung.product.persistence.service;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import io.github.sejoung.product.persistence.repository.ProductRepository;
import io.github.sejoung.product.persistence.util.TestUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@DataJpaTest
class SaveRoundProductServiceTest {

    @Autowired
    private ProductRepository repository;

    private SaveRoundProductService service;

    @BeforeEach
    void setUp() {
        service = new SaveRoundProductService(repository);
    }

    @Test
    void saveRoundProduct() {
        var actual = service.saveRoundProduct(TestUtil.defaultRoundProduct());
        log.debug("{}",actual);
        assertThat(actual.getProductId()).isNotNull();

    }
}