package io.github.sejoung.product.rest;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.github.sejoung.product.rest.util.SaveRoundProductInUseCaseStub;
import io.github.sejoung.product.usecases.port.in.SaveRoundProductInUseCase;

@SpringBootApplication
public class TestApplication {
    @Bean
    public SaveRoundProductInUseCase saveRoundProductInUseCase() {
        return new SaveRoundProductInUseCaseStub();
    }
}
