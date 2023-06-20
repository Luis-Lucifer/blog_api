package com.nilanjan.blogapi.service;

import com.nilanjan.blogapi.dto.BlogDTO;
import com.nilanjan.blogapi.model.Blog;
import com.nilanjan.blogapi.repository.BlogRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BlogServiceImpl implements BlogService {

    private final BlogRepository blogRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<BlogDTO> getAllBlogs() {
        List<Blog> blogs = blogRepository.findAll();
        return blogs.stream()
                .map(blog -> modelMapper.map(blog, BlogDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public BlogDTO createBlog(BlogDTO blogDTO) {
        Blog blog = modelMapper.map(blogDTO, Blog.class);
        Blog createdBlog = blogRepository.save(blog);
        return modelMapper.map(createdBlog, BlogDTO.class);
    }

    @Override
    public BlogDTO getBlogById(Long id) {
        Blog blog = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid blog id: " + id));
        return modelMapper.map(blog, BlogDTO.class);
    }

    @Override
    public BlogDTO updateBlog(Long id, BlogDTO updatedBlogDTO) {
        Blog updatedBlog = modelMapper.map(updatedBlogDTO, Blog.class);
        Blog blog = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid blog id: " + id));

        modelMapper.map(updatedBlog, blog);
        Blog savedBlog = blogRepository.save(blog);
        return modelMapper.map(savedBlog, BlogDTO.class);
    }

    @Override
    public void deleteBlog(Long id) {
        blogRepository.deleteById(id);
    }
}
