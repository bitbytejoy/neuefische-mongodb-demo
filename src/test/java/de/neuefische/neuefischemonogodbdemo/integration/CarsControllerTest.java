package de.neuefische.neuefischemonogodbdemo.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class CarsControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    void create_whenCar_thenCreateCar () throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/api/cars")
            .contentType(MediaType.APPLICATION_JSON)
            .content("""
                {
                    "brand": "Golf",
                    "year": 2019
                }
            """)
        ).andExpectAll(
            MockMvcResultMatchers.status().isOk(),
            MockMvcResultMatchers.content().json("""
                {
                    "brand": "Golf",
                    "year": 2019
                }
            """)
        );
    }

    @Test
    void getAll_whenEmpty_thenEmpty () throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/api/cars"))
            .andExpectAll(
                MockMvcResultMatchers.status().isOk(),
                MockMvcResultMatchers.content().json("[]")
            );
    }
}