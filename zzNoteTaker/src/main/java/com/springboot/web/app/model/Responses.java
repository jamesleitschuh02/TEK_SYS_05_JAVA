package com.springboot.web.app.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
@Entity
@Table(name = "responses")
public class Responses {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "response_desc")
	private String responseDesc;
	
	@Column(name = "date_created")
	private LocalDateTime createdAt = LocalDateTime.now();
	
	@ManyToOne(
			cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "postsId", nullable = false)
	@JsonBackReference
	private Posts posts;
	
	@ManyToOne(
			cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "userId", nullable = false)
	@JsonBackReference
	private User user;

}
