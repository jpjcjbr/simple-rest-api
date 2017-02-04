package br.com.geoambiente.collect.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.util.StringUtils;

import br.com.geoambiente.collect.controller.dto.CollectFilter;

public class CollectRepositoryImpl implements CollectRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	@Override
	@SuppressWarnings("unchecked")
	public List<Collect> findByFilter(CollectFilter collectFilter) {
		Session session = em.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Collect.class, "c");
		
		if(collectFilter.hasValidDates()) {
			criteria.add(Restrictions.between("date", collectFilter.getStart(), collectFilter.getEnd()));
		}
		
		if(!StringUtils.isEmpty(collectFilter.getDescription())) {
			criteria.add(Restrictions.ilike("description", "%" + collectFilter.getDescription() + "%"));
		}
		
		if(!StringUtils.isEmpty(collectFilter.getLocation())) {
			criteria.add(Restrictions.ilike("location", "%" + collectFilter.getLocation() + "%"));
		}
		

		return criteria.list();
	}

}
