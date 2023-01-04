package com.codegym.repository;

import com.codegym.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    @Query(value = "select * from blog  where title concat('%', :tileInput, '%')", nativeQuery = true)
    List<Blog> listSort(@Param("tileInput") String title);
}
