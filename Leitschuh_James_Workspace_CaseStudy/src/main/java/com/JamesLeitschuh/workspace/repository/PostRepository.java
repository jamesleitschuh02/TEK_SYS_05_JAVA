package com.JamesLeitschuh.workspace.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JamesLeitschuh.workspace.model.Post;

public interface PostRepository extends JpaRepository<Post, Long>{

}
