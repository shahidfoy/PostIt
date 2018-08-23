package com.charles.overstack.posts.domain.services;

import java.util.Optional;
import java.util.UUID;
import com.charles.overstack.posts.domain.models.Post;
import com.charles.overstack.posts.domain.repositories.PostRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class PostService {

	private final PostRepository postRepository;

	public PostService(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	public Post insertNewPost(Post post) {
		Post newpost = new Post();
		newpost.setId(UUID.randomUUID().toString());
		newpost.setTitle(post.getTitle());
		newpost.setPostBody(post.getPostBody());
		newpost.setPostDate(post.getPostDate());
		return this.postRepository.save(newpost);
	}

	public Post updatePost(String id, Post post) {
		Optional<Post> postOptional = postRepository.findById(id);

		if(!postOptional.isPresent()) {
			throw new RuntimeException("Post not found");
		}
		Post updatedpost = postOptional.get();

		updatedpost.setTitle(post.getTitle());
		updatedpost.setPostBody(post.getPostBody());
		updatedpost.setPostDate(post.getPostDate());

		return this.postRepository.save(updatedpost);
	}

	public Page<Post> getAllPosts(int page) {
		Page<Post> postsPage;
		postsPage = postRepository.findAll(PageRequest.of(page, 10));
		return postsPage;
	}

	public Post findPostById(String id) {
		Optional<Post> postOptional = postRepository.findById(id);

		if(!postOptional.isPresent()) {
			throw new RuntimeException("Post not found");
		}

		return postOptional.get();
	}

	public Post savePost(Post post) {
		return postRepository.save(post);
	}

	public void deletePost(String id) {
		postRepository.deleteById(id);
	}
}
