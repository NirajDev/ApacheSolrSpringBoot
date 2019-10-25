package com.junglee.solr.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.junglee.solr.model.Event;
import com.junglee.solr.repository.EventRepo;

@RestController

public class searchController {

	@Autowired
	private EventRepo repository;

	@PostConstruct
	public void addEvents() {
		List<Event> events = new ArrayList<>();
		events.add(new Event(1, "ENNOGY 2K19", "Delhi", "28.534693, 77.260178"));
		events.add(new Event(2, "The Great Indian Music Festival", "Noida", "28.582121, 77.326698"));
		events.add(new Event(3, "Dandiya Nights", "Gurgaon", "27.659361, 76.917007"));
		repository.saveAll(events);

	}

	@GetMapping("/")
	public Iterable<Event> getEvents() {
		return repository.findAll();
	}

	@GetMapping("/solrQuery")
	public Iterable<Event> solrQuery(String searchQuery) {
		return repository.resultBySolrQuery();
	}

	@GetMapping("/getEvents/{id}")
	public Event getEventsByName(@PathVariable int id) {
		return repository.findById(id);
	}
	
	@GetMapping("/getEventsByDist")
	public Event getEventsByDist() {
		return repository.getEventsByDist();
	}
	
}
