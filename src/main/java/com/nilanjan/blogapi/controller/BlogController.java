package com.nilanjan.blogapi.controller;
import com.nilanjan.blogapi.dto.BlogDTO;
import com.nilanjan.blogapi.service.BlogService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;




@RestController
@RequestMapping("/api/blogs")
@AllArgsConstructor
public class BlogController {

    private final BlogService blogService;

    @GetMapping
    public List<BlogDTO> getAllBlogs() {
        return blogService.getAllBlogs();
    }

    @PostMapping
    public BlogDTO createBlog(@RequestBody BlogDTO blogDTO) {
        return blogService.createBlog(blogDTO);
    }

    @GetMapping("/{id}")
    public BlogDTO getBlogById(@PathVariable Long id) {
        return blogService.getBlogById(id);
    }

    @PutMapping("/{id}")
    public BlogDTO updateBlog(@PathVariable Long id, @RequestBody BlogDTO updatedBlogDTO) {
        return blogService.updateBlog(id, updatedBlogDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteBlog(@PathVariable Long id) {
        blogService.deleteBlog(id);
    }
}
