package io.github.sejoung.product.persistence.repository;

import static org.assertj.core.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import io.github.sejoung.product.persistence.constants.ProductStatus;
import io.github.sejoung.product.persistence.entities.PeriodProductEntity;
import io.github.sejoung.product.persistence.entities.RoundProductEntity;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private TestEntityManager entityManager;

    @DisplayName("조회기능 테스트")
    @Test
    void findAllTest() {

        entityManager.persistAndFlush(new RoundProductEntity("회차권", 1L, ProductStatus.CREATE, 1));
        entityManager.persistAndFlush(
            new PeriodProductEntity("ad", 1L, ProductStatus.CREATE, LocalDate.now(), LocalDate.now().plusDays(1)));
        var productEntities = repository.findAll();
        assertThat(productEntities.size()).isEqualTo(2);

    }
}