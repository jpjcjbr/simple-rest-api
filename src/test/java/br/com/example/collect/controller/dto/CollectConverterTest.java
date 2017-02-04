package br.com.example.collect.controller.dto;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.hamcrest.Matchers;
import org.junit.Test;

import br.com.example.collect.controller.dto.CollectConverter;
import br.com.example.collect.controller.dto.CollectDTO;
import br.com.example.collect.model.Collect;

public class CollectConverterTest {

	private static final long ID = 1L;
	private static final LocalDateTime DATE = LocalDateTime.now();
	private static final String DESCRIPTION = "collect description";
	private static final String LOCATION = "location";
	private CollectConverter collectConverter = new CollectConverter();
	
	@Test
	public void shouldConvertToDTO() {
		Collect collect = new Collect();
		
		collect.setId(ID);
		collect.setDate(DATE);
		collect.setDescription(DESCRIPTION);
		collect.setLocation(LOCATION);
		
		CollectDTO dto = collectConverter.toDTO(collect);
		
		assertThat(dto.getId(), Matchers.equalTo(ID));
		assertThat(dto.getDate(), Matchers.equalTo(DATE));
		assertThat(dto.getDescription(), Matchers.equalTo(DESCRIPTION));
		assertThat(dto.getLocation(), Matchers.equalTo(LOCATION));
	}
	
	@Test
	public void shouldConvertToModel() {
		CollectDTO collectDTO = new CollectDTO();
		
		collectDTO.setId(ID);
		collectDTO.setDate(DATE);
		collectDTO.setDescription(DESCRIPTION);
		collectDTO.setLocation(LOCATION);
		
		Collect model = collectConverter.toModel(collectDTO);
		
		assertThat(model.getId(), Matchers.equalTo(ID));
		assertThat(model.getDate(), Matchers.equalTo(DATE));
		assertThat(model.getDescription(), Matchers.equalTo(DESCRIPTION));
		assertThat(model.getLocation(), Matchers.equalTo(LOCATION));
	}

}
