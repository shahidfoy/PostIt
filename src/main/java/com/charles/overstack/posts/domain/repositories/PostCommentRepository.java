package com.charles.overstack.posts.domain.repositories;

import com.charles.overstack.posts.domain.models.PostComment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostCommentRepository extends MongoRepository<PostComment, String> {

}
