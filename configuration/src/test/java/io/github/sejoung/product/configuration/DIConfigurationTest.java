package io.github.sejoung.product.configuration;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import io.github.sejoung.product.usecases.port.in.SaveRoundProductInUseCase;

@SpringBootTest
class DIConfigurationTest {

    @Autowired
    private SaveRoundProductInUseCase saveRoundProductInUseCase;

    @Test
    void diTest() {
        assertThat(saveRoundProductInUseCase).isNotNull();
    }
}