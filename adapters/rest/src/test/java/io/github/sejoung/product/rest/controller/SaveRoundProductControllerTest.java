package io.github.sejoung.product.rest.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.sejoung.product.rest.util.RestTestUtil;
import io.github.sejoung.product.rest.util.SaveRoundProductInUseCaseStub;
import io.github.sejoung.product.usecases.port.in.SaveRoundProductInUseCase;

@WebMvcTest(controllers = SaveRoundProductController.class)
class SaveRoundProductControllerTest {

    private static final String URL = "/product/round";

    @Autowired
    private MockMvc mockMvc;

    @DisplayName("회차권 API 테스트")
    @Test
    void saveRoundProduct() throws Exception {

        var objectMapper = new ObjectMapper();
        var json = objectMapper.writeValueAsString(RestTestUtil.defaultSaveRoundProductCommand(null));
        mockMvc.perform(post(URL)
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            .content(json))
            .andDo(print())
            .andExpect(status().isOk());

    }
}