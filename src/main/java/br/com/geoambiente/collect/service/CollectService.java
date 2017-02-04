package br.com.geoambiente.collect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import br.com.geoambiente.collect.model.Collect;
import br.com.geoambiente.collect.model.CollectRepository;
import br.com.geoambiente.util.exception.BusinessException;

@Service
public class CollectService {

	public static final String MAX_COLLECT_NUMBER_PER_LOCATION_EXCEEDED = "max.collect.number.per.location.exceeded";

	public static final int MAX_COLLECT_PER_LOCATION = 5;
	
	@Autowired
	private CollectRepository collectRepository;
	
	public List<Collect> find() {
		return Lists.newArrayList(collectRepository.findAll());
	}

	public Collect create(Collect collect) {
		if(collectRepository.findByLocation(collect.getLocation()).size() >= MAX_COLLECT_PER_LOCATION) {
			throw new BusinessException(MAX_COLLECT_NUMBER_PER_LOCATION_EXCEEDED);
		}
		
		return collectRepository.save(collect);
	}


}
