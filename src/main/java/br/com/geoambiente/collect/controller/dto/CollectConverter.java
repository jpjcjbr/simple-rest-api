package br.com.geoambiente.collect.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.geoambiente.collect.model.Collect;

@Component
public class CollectConverter {

	public Collect toModel(CollectDTO collectDTO) {
		Collect collect = new Collect();
		
		collect.setDate(collectDTO.getDate());
		collect.setDescription(collectDTO.getDescription());
		collect.setId(collectDTO.getId());
		collect.setLocation(collectDTO.getLocation());
		
		return collect;
	}

	public List<CollectDTO> toDTO(List<Collect> collects) {
		return collects.stream().map(c -> toDTO(c)).collect(Collectors.toList());
	}
	
	public CollectDTO toDTO(Collect collect) {
		CollectDTO collectDTO = new CollectDTO();
		
		collectDTO.setDate(collect.getDate());
		collectDTO.setDescription(collect.getDescription());
		collectDTO.setId(collect.getId());
		collectDTO.setLocation(collect.getLocation());
		
		return collectDTO;
	}

}
