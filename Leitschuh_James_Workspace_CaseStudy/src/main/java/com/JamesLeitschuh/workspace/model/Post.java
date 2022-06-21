package com.JamesLeitschuh.workspace.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity
@Table(name = "posts")
public class Post {
	
	@Id
	@Column(name = "post_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "post_name", nullable = false)
	private String postName;
	
	@Column(name = "post_desc", nullable = false)
	private String postDesc;
	
	@Column(name = "date_created")
	private LocalDateTime createdAt = LocalDateTime.now();
	
	@ManyToOne(
			cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "userId", nullable = false)
	@JsonBackReference
	private User user;
	
	@OneToMany(
			mappedBy = "posts",
			cascade = CascadeType.ALL,
			fetch = FetchType.LAZY,
			orphanRemoval = true
			)
	@JsonManagedReference
	private List<Comment> comments = new ArrayList<>();

}
