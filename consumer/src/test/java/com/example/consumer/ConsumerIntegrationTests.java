package com.example.consumer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureStubRunner(
        ids = "com.example.provider:provider:0.0.1-SNAPSHOT:stubs:9999",
        stubsMode = StubRunnerProperties.StubsMode.LOCAL
)
public class ConsumerIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void get_consumer_by_id() throws Exception {
        this.mockMvc.perform(
                        get("/consumer/1"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello Test firstname")));
    }

}
