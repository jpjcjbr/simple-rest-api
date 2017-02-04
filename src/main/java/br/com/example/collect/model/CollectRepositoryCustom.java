package br.com.example.collect.model;

import java.util.List;

import br.com.example.collect.controller.dto.CollectFilter;

public interface CollectRepositoryCustom {

	List<Collect> findByFilter(CollectFilter collectFilter);
}
