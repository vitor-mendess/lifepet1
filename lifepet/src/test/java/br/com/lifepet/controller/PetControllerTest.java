package br.com.lifepet.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PetControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private String obterToken() throws Exception {

        MvcResult resultado = mockMvc.perform(
                post("/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"email\":\"vitor@email.com\",\"senha\":\"123456\"}")
        ).andExpect(status().isOk()).andReturn();

        JsonNode resposta = objectMapper.readTree(
                resultado.getResponse().getContentAsString()
        );

        return resposta.get("token").asText();
    }

    @Test
    void deveListarPets() throws Exception {

        String token = obterToken();

        mockMvc.perform(
                get("/pets")
                        .header("Authorization", "Bearer " + token)
        ).andExpect(status().isOk());
    }
}