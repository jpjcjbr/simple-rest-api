package br.com.geoambiente.collect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.geoambiente.collect.controller.dto.CollectConverter;
import br.com.geoambiente.collect.controller.dto.CollectDTO;
import br.com.geoambiente.collect.service.CollectService;

@RestController
@RequestMapping("/collects")
public class CollectController {
	
	@Autowired
	private CollectService collectService;
	
	@Autowired
	private CollectConverter collectConverter;
	
	@RequestMapping(method = RequestMethod.POST)
	public Long create(@RequestBody CollectDTO collectDTO) {
		return collectService.create(collectConverter.toModel(collectDTO)).getId();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<CollectDTO> listAll() {
		return collectConverter.toDTO(collectService.find());
	}
}
