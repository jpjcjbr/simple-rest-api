package br.com.geoambiente.collect.controller;

import static org.junit.Assert.assertThat;

import java.time.LocalDateTime;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.geoambiente.collect.controller.dto.CollectDTO;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:db/migration/V001_001__create_collect.sql")
@Sql(executionPhase = ExecutionPhase.AFTER_TEST_METHOD, statements = "DROP TABLE COLLECT;")
public class CollectControllerIntegrationTest {

	private static final long ID = 1L;

	private static final LocalDateTime DATE = LocalDateTime.now();

	private static final String DESCRIPTION = "description for test";

	private static final String LOCATION = "location for test";

	@Autowired
    private TestRestTemplate restTemplate;
	
	@Test
	public void shouldCreateCollect() {
		Long collectId = createCollect();
		
		assertThat(collectId, Matchers.equalTo(ID));
	}

	@Test
	public void shouldListCollects() {
		createCollect();
		
		CollectDTO[] collects = restTemplate.getForObject("/collects", CollectDTO[].class);
		
		assertThat(collects.length, Matchers.equalTo(1));
		assertThat(collects[0].getId(), Matchers.equalTo(ID));
		assertThat(collects[0].getDate(), Matchers.equalTo(DATE));
		assertThat(collects[0].getDescription(), Matchers.equalTo(DESCRIPTION));
		assertThat(collects[0].getLocation(), Matchers.equalTo(LOCATION));
	}

	private CollectDTO getCollectDTO() {
		CollectDTO collectDTO = new CollectDTO();
		
		collectDTO.setDate(DATE);
		collectDTO.setDescription(DESCRIPTION);
		collectDTO.setLocation(LOCATION);
		
		return collectDTO;
	}
	
	private Long createCollect() {
		Long collectId = restTemplate.postForObject("/collects", getCollectDTO(), Long.class);
		return collectId;
	}

}
