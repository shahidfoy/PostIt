package com.charles.overstack.posts.domain.controllers;

import com.charles.overstack.posts.domain.models.Post;
import com.charles.overstack.posts.domain.services.PostService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
public class PostController {

	private final PostService postService;

	public PostController(PostService postService) {
		this.postService = postService;
	}

	@GetMapping(value = "/post/{id}")
	public ResponseEntity<Post> findPost(@PathVariable("id") String id) {
		return ResponseEntity.ok(this.postService.findPostById(id));
	}

	@GetMapping
	public ResponseEntity<Page<Post>> findAllPosts(@RequestParam(defaultValue="0") int page) {
		return ResponseEntity.ok(this.postService.getAllPosts(page));
	}

	@PostMapping
	public ResponseEntity<Post> newPost(Post post) {
		return new ResponseEntity<>(this.postService.insertNewPost(post), HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removePost(@PathVariable("id") String id) {
		this.postService.deletePost(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Post> update(@PathVariable("id") String id, Post post) {
		return new ResponseEntity<>(this.postService.updatePost(id, post), HttpStatus.OK);
	}


}
