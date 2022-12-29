package com.codegym.repository;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    @Query(value = "select * from blog ", nativeQuery = true)
    Page<Blog> listSort(Pageable pageable);
}
