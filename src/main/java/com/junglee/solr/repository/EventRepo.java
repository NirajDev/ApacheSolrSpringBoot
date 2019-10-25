package com.junglee.solr.repository;

import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;

import com.junglee.solr.model.Event;

public interface EventRepo extends SolrCrudRepository<Event, Integer> {

	Event findById(int id);

	@Query("id:*1* OR id:*2*")
	Iterable<Event> resultBySolrQuery();

	@Query("fq={!geofilt}&sfield=latlon&pt=28.534693, 77.260178&d=50&sort=geodist() asc")
	Event getEventsByDist();
}
