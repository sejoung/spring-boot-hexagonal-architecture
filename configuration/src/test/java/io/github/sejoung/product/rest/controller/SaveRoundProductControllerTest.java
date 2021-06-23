package io.github.sejoung.product.rest.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.sejoung.product.rest.util.RestTestUtil;

@SpringBootTest
@AutoConfigureMockMvc
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