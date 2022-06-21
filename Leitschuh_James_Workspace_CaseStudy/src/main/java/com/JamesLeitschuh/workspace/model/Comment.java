package com.JamesLeitschuh.workspace.model;

import java.time.LocalDateTime;

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
@Table(name = "comments")
public class Comment {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "response_desc")
	private String commentDesc;
	
	@Column(name = "date_created")
	private LocalDateTime createdAt = LocalDateTime.now();
	
	@ManyToOne(
			cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "postsId", nullable = false)
	@JsonBackReference
	private Post posts;
	
	@ManyToOne(
			cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "userId", nullable = false)
	@JsonBackReference
	private User user;

}
