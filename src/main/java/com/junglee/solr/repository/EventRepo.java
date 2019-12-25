package com.junglee.solr.repository;

import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.FilterQuery;
import org.springframework.data.solr.core.query.SimpleFilterQuery;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;

import com.junglee.solr.model.Event;

public interface EventRepo extends SolrCrudRepository<Event, Integer> {

	Event findById(int id);

	@Query("id:*1* OR id:*2*")
	Iterable<Event> resultBySolrQuery();

	@Query("lon:[77 TO 85]&fq=lat:[19 TO 28")
	Event getEventsByDist();
	
	
}
