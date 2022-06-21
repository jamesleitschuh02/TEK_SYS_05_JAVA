package com.springboot.web.app.model;

import java.util.Objects;

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
import lombok.ToString;

@Data
@Entity
@Table(name="notes")
public class Notes {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "noteName")
	private String noteName;
	
	@Column(name = "noteContent")
	private String noteContent;
	
	@ManyToOne(
			cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
//	@ToString.Exclude
//	@JoinColumn(name = "user_id", nullable = false, referencedColumnName="id")
	@JoinColumn(name = "userId", nullable = false)
	@JsonBackReference
	private User user;


}
