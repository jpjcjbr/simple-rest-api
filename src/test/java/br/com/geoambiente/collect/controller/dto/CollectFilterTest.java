package br.com.geoambiente.collect.controller.dto;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Test;

public class CollectFilterTest {

	@Test
	public void shouldDatesBeInvalidWhenStartIsNull() {
		CollectFilter collectFilter = new CollectFilter();
		collectFilter.setEnd(LocalDateTime.now());
		
		assertFalse(collectFilter.hasValidDates());
	}
	
	@Test
	public void shouldDatesBeInvalidWhenEndIsNull() {
		CollectFilter collectFilter = new CollectFilter();
		collectFilter.setStart(LocalDateTime.now());
		
		assertFalse(collectFilter.hasValidDates());
	}
	
	@Test
	public void shouldDatesBeInvalidWhenBothAreNull() {
		CollectFilter collectFilter = new CollectFilter();
		
		assertFalse(collectFilter.hasValidDates());
	}
	
	@Test
	public void shouldDatesBeValid() {
		CollectFilter collectFilter = new CollectFilter();
		collectFilter.setStart(LocalDateTime.now());
		collectFilter.setEnd(LocalDateTime.now());
		
		assertTrue(collectFilter.hasValidDates());
	}

}
