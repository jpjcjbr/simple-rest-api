package br.com.geoambiente.collect.service;

import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.geoambiente.collect.model.Collect;
import br.com.geoambiente.collect.model.CollectRepository;
import br.com.geoambiente.util.exception.BusinessException;

@RunWith(MockitoJUnitRunner.class)
public class CollectServiceTest {

	@InjectMocks
	private CollectService collectService = new CollectService();
	
	@Mock
	private CollectRepository collectRepository;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void shouldCreateCollect() {
		Collect expectedCollect = new Collect();
		BDDMockito.given(collectRepository.save(Mockito.any(Collect.class))).willReturn(expectedCollect);
		
		Collect createdCollect = collectService.create(new Collect());
		
		assertThat(createdCollect, Matchers.equalTo(expectedCollect));
	}
	
	@Test
	public void shouldThrowExceptionWhenMaxCollectNumberPerLocationIsExceeded() {
		BDDMockito.given(collectRepository.findByLocation(Mockito.anyString())).willReturn(getListWithMaxCollectNumberForOneLocation());
		thrown.expect(BusinessException.class);
		thrown.expectMessage(CollectService.MAX_COLLECT_NUMBER_PER_LOCATION_EXCEEDED);
		
		collectService.create(new Collect());
	}
	
	@Test
	public void shouldFindAll() {
		BDDMockito.given(collectRepository.findAll()).willReturn(new ArrayList<>());
		
		collectService.find();
		
		Mockito.verify(collectRepository).findAll();
	}
	
	private List<Collect> getListWithMaxCollectNumberForOneLocation() {
		List<Collect> collects = new ArrayList<>();
		
		for(int i = 0; i < CollectService.MAX_COLLECT_PER_LOCATION; i++) {
			collects.add(new Collect());
		}
		
		return collects;
	}

}
