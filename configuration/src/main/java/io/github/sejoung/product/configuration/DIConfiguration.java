package io.github.sejoung.product.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.sejoung.product.persistence.repository.ProductRepository;
import io.github.sejoung.product.persistence.service.JPASaveRoundProductService;
import io.github.sejoung.product.usecases.port.in.SaveRoundProductInUseCase;
import io.github.sejoung.product.usecases.service.DomainSaveRoundProductService;

@Configuration
public class DIConfiguration {

    @Bean
    public SaveRoundProductInUseCase saveRoundProductInUseCase(ProductRepository repository) {
        return new DomainSaveRoundProductService(new JPASaveRoundProductService(repository));
    }

}
