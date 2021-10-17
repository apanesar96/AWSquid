package com.codurance.cephalopodwebsite;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CephalopodWebsiteService.class)
@ActiveProfiles("staging")
public class CephalopodWebsiteServiceProductionTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void getSquidReturns200ResponseForSeasonalSquidStaging() throws Exception {
        this.mockMvc.perform(get("/getSquid"))
                .andExpect(status().isOk())
                .andExpect(content().string("http://localhost:3002/seasonalSquid"));
    }
}
