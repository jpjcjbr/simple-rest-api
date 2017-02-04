package br.com.geoambiente.collect.model;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.geoambiente.collect.controller.dto.CollectFilter;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CollectRepositoryTest {

	@Autowired
	private TestEntityManager em;
	
	@Autowired
	private CollectRepository collectRepository;

	@Before
	public void setUp() {
		em.persist(new Collect(LocalDateTime.now().minusDays(1), "desc1", "location1_ABC_123"));
		em.persist(new Collect(LocalDateTime.now().minusDays(10), "desc2", "location2_DEF_456"));
	}
	
	@Test
	public void shouldFindWithEmptyFilter() {
		List<Collect> findByFilter = collectRepository.findByFilter(new CollectFilter());
		
		assertThat(findByFilter.size(), equalTo(2));
	}
	
	@Test
	public void shouldFilterByDate() {
		CollectFilter collectFilter = new CollectFilter();
		collectFilter.setStart(LocalDateTime.now().minusDays(5));
		collectFilter.setEnd(LocalDateTime.now());
		
		List<Collect> findByFilter = collectRepository.findByFilter(collectFilter);
		
		assertThat(findByFilter.size(), equalTo(1));
		assertThat(findByFilter.get(0).getDescription(), equalTo("desc1"));
	}
	
	@Test
	public void shouldFilterByLocationLike() {
		CollectFilter collectFilter = new CollectFilter();
		collectFilter.setLocation("dEf");
		
		List<Collect> findByFilter = collectRepository.findByFilter(collectFilter);
		
		assertThat(findByFilter.size(), equalTo(1));
		assertThat(findByFilter.get(0).getDescription(), equalTo("desc2"));
	}
	
	@Test
	public void shouldFilterByDescriptionLike() {
		CollectFilter collectFilter = new CollectFilter();
		collectFilter.setDescription("EsC1");
		
		List<Collect> findByFilter = collectRepository.findByFilter(collectFilter);
		
		assertThat(findByFilter.size(), equalTo(1));
		assertThat(findByFilter.get(0).getDescription(), equalTo("desc1"));
	}

}
