package com.aakash.blog.services;

import com.aakash.blog.domain.CreatePostRequest;
import com.aakash.blog.domain.UpdatePostRequest;
import com.aakash.blog.domain.entities.Post;
import com.aakash.blog.domain.entities.User;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;


public interface PostService {
    Post getPost(UUID id);
    List<Post> getAllPosts(UUID categoryId, UUID tagId);
    List<Post> getDraftPosts(User user);
    Post createPost(User user, CreatePostRequest createPostRequest);
    Post updatePost(UUID id, UpdatePostRequest updatePostRequest);
    void deletePost(UUID id);
}
