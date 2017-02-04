package br.com.geoambiente.collect.model;

import java.util.List;

import br.com.geoambiente.collect.controller.dto.CollectFilter;

public interface CollectRepositoryCustom {

	List<Collect> findByFilter(CollectFilter collectFilter);
}
