package io.github.sejoung.product.rest.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.github.sejoung.product.rest.dto.SaveRoundProduct;
import io.github.sejoung.product.rest.mapper.SaveRoundProductMapper;
import io.github.sejoung.product.usecases.port.in.SaveRoundProductInUseCase;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class SaveRoundProductController {

    private final SaveRoundProductInUseCase saveRoundProductInUseCase;

    public SaveRoundProductController(
        SaveRoundProductInUseCase saveRoundProductInUseCase) {
        this.saveRoundProductInUseCase = saveRoundProductInUseCase;
    }

    @PostMapping("/product/round")
    public SaveRoundProduct roundSave(
        @Valid @RequestBody SaveRoundProduct dto) {
        log.debug("{}", dto);
        var command = saveRoundProductInUseCase.save(SaveRoundProductMapper.toEntity(dto));
        return SaveRoundProductMapper.toDto(command);
    }
}
