package sla.tacoscloud.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by Antony Genil Gregory on 11/28/2019 2:26 PM
 * For project : tacos-cloud
 **/
@RunWith(SpringRunner.class)
@WebMvcTest(TacoController.class)
class TacoControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetTacos() throws Exception{
        mockMvc.perform(get("/")).andExpect(status().isOk()).
                andExpect(view().name("Tacos")).
                andExpect(content().string(containsString("Welcome to..")));
    }
}