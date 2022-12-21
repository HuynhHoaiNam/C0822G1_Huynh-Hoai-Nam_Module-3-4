package com.example.test.repository;

import com.example.test.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IBlogRepository extends JpaRepository<Blog, Integer> {
}
