package com.example.consumer;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureStubRunner(
		ids = "com.example.provider:provider:0.0.1-SNAPSHOT:stubs:9999",
		stubsMode = StubRunnerProperties.StubsMode.LOCAL
)
public class ConsumerContractTests {

	@Test
	public void get_consumer_by_id() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<UserResponse> responseEntity = restTemplate.getForEntity(
				"http://localhost:9999/users/1", UserResponse.class);
		assertEquals(200, responseEntity.getStatusCodeValue());
		assertEquals("Demo", responseEntity.getBody().getFirstname());
	}

}
