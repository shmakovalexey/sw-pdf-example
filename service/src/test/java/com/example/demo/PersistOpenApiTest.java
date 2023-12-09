package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PersistOpenApiTest {

	private static final String PERSIST_PATH = "target/api-doc.json";

	@LocalServerPort
	int localPort;

	@Value("${springdoc.api-docs.path}")
	String  apiDocPath;

	@Autowired
	ObjectMapper mapper;

	RestTemplate restTemplate = new RestTemplate();

	@Test
	public void persistOpenApiSpec() throws Exception {
		log.info("loading openApiSpec");
		String openApiSpec = restTemplate.getForObject("http://localhost:" + localPort +  apiDocPath, String.class);
		log.info("openApiSpec is {}", openApiSpec);
		Assertions.assertNotNull(openApiSpec);
		Files.writeString(Paths.get(PERSIST_PATH), prettyJson(openApiSpec));
	}

	private String prettyJson(String json) throws Exception {
		var mapSpec = mapper.readValue(json, Map.class);
		return mapper.writer().withDefaultPrettyPrinter()
				.writeValueAsString(mapSpec);
	}

}
