package com.charles.overstack.posts.domain.repositories;

import com.charles.overstack.posts.domain.models.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {

}
