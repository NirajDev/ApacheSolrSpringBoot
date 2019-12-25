package com.junglee.solr.model;


import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.geo.Point;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SolrDocument(collection = "eventdata")

public class Event {
	@Id
	@Field
	@Indexed
	private int id;
	
	@Field
	@Indexed
	private String eventName;

	@Indexed
	@Field
	private String place;
	
	@Indexed
	@Field
	private Point myLocationField;

}
