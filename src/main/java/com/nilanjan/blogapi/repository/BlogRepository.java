package com.nilanjan.blogapi.repository;

import com.nilanjan.blogapi.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Long> {
}
