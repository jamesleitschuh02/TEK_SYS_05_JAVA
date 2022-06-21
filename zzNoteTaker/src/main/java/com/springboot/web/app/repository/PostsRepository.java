package com.springboot.web.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.web.app.model.Posts;

public interface PostsRepository extends JpaRepository<Posts, Long> {

}
