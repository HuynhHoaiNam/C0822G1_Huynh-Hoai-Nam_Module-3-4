package com.example.test.service.impl;

import com.example.test.model.Blog;
import com.example.test.repository.IBlogRepository;
import com.example.test.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(int id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Optional<Blog> findAllById(int id) {
        return blogRepository.findById(id);
    }

    @Override
    public void edit(Blog blog) {
        blogRepository.save(blog);
    }
}
