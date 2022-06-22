package com.JamesLeitschuh.workspace.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;


import lombok.Data;

@Data
@Entity
@Table(name="user")
public class User {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@Column(name = "last_name", nullable = false)
	private String lastName;
	
	@Column(name = "email", nullable = false, unique=true)
	private String email;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "city")
	private String city;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			name = "users_roles",
			joinColumns = @JoinColumn(
		            name = "user_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(
				            name = "role_id", referencedColumnName = "id"))	
	private Collection<Role> roles;
	
	@OneToMany(
			mappedBy = "user",
			cascade = CascadeType.ALL,
			fetch = FetchType.LAZY,
			orphanRemoval = true
			)
	@JsonManagedReference
	private List<Note> notepads = new ArrayList<>();
	
	@OneToMany(
			mappedBy = "user",
			cascade = CascadeType.ALL,
			fetch = FetchType.LAZY,
			orphanRemoval = true
			)
	@JsonManagedReference
	private List<Task> tasks = new ArrayList<>();
	
	@OneToMany(
			mappedBy = "user",
			cascade = CascadeType.ALL,
			fetch = FetchType.LAZY,
			orphanRemoval = true
			)
	@JsonManagedReference
	private List<Event> events = new ArrayList<>();
	
	@OneToMany(
			mappedBy = "user",
			cascade = CascadeType.ALL,
			fetch = FetchType.LAZY,
			orphanRemoval = true
			)
	@JsonManagedReference
	private List<Post> posts = new ArrayList<>();
	
	@OneToMany(
			mappedBy = "user",
			cascade = CascadeType.ALL,
			fetch = FetchType.LAZY,
			orphanRemoval = true
			)
	@JsonManagedReference
	private List<Comment> comments = new ArrayList<>();

	
	
}
