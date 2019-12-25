package com.junglee.solr.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.net.ssl.HttpsURLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
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
	public void addEvents() throws IOException {
		List<Event> events = new ArrayList<>();
		events.add(new Event(1, "ENNOGY 2K19", "Delhi", new Point(28.885, 77.444)));
		events.add(new Event(2, "The Great Indian Music Festival", "Noida", new Point(32.232, 85.3333)));
		events.add(new Event(3, "Dandiya Nights", "Gurgaon", new Point(20.123, 85.321)));
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
	public Event getEventsByName(@PathVariable int id) throws MalformedURLException, IOException {

		return repository.findById(id);
	}

	@GetMapping("/getEventsByDist")
	public Event getEventsByDist() {
		return repository.getEventsByDist();
	}
}
