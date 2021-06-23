package io.github.sejoung.product.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import io.github.sejoung.product.constants.ProductType;
import io.github.sejoung.product.entities.RoundProductEntity;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    void test() {

        entityManager.persistAndFlush(new RoundProductEntity("회차권", ProductType.ROUND, 1L, 1));

        repository.findAll().forEach(productEntity -> {
            System.out.println(productEntity);
        });
    }
}