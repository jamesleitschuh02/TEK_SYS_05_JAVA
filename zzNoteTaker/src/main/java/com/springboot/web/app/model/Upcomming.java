package com.springboot.web.app.model;

import java.time.LocalDate;
import java.util.Date;

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

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
@Entity
@Table(name = "upcomming")
public class Upcomming {
	
	@Id
	@Column(name = "upcommingId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long upcommingId;
	
	@Column(name = "eventName")
	private String eventName;
	
	@Column(name = "eventDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date eventDate;
	
	@Column(name = "eventTime")
	private String eventTime;
	
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "userId", nullable = false)
	@JsonBackReference
	private User user;
	
}
