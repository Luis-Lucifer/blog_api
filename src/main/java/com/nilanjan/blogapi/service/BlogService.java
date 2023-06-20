package com.nilanjan.blogapi.service;

import com.nilanjan.blogapi.dto.BlogDTO;

import java.util.List;

public interface BlogService {
    List<BlogDTO> getAllBlogs();

    BlogDTO createBlog(BlogDTO blogDTO);

    BlogDTO getBlogById(Long id);

    BlogDTO updateBlog(Long id, BlogDTO updatedBlogDTO);

    void deleteBlog(Long id);
}

