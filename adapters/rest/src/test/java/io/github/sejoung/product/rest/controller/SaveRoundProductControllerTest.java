package io.github.sejoung.product.rest.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.sejoung.product.rest.util.RestTestUtil;

@WebMvcTest(controllers = SaveRoundProductController.class)
class SaveRoundProductControllerTest {

    private static final String URL = "/product/round";

    @Autowired
    private MockMvc mockMvc;

    @DisplayName("회차권 API 테스트")
    @Test
    void saveRoundProduct() throws Exception {

        var objectMapper = new ObjectMapper();
        var roundProductCommand = RestTestUtil.defaultSaveRoundProductCommand(null);
        var json = objectMapper.writeValueAsString(RestTestUtil.defaultSaveRoundProductCommand(null));
        mockMvc.perform(post(URL)
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            .content(json))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.productId").value(1))
            .andExpect(jsonPath("$.categoryId").value(roundProductCommand.getCategoryId()))
            .andExpect(jsonPath("$.productType").value(roundProductCommand.getProductType().name()))
            .andExpect(jsonPath("$.status").value(roundProductCommand.getStatus().name()))
            .andExpect(jsonPath("$.productName").value(roundProductCommand.getProductName()))
            .andExpect(jsonPath("$.count").value(roundProductCommand.getCount()));

    }
}