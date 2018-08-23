package com.charles.overstack.posts.domain.models;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "comments")
public class PostComment {

	@Id
	private String id;

	private String commentBody;
	private Date commentDate;

	public PostComment() {}

	public PostComment(String commentBody, Date commentDate) {
		this.commentBody = commentBody;
		this.commentDate = commentDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCommentBody() {
		return commentBody;
	}

	public void setCommentBody(String commentBody) {
		this.commentBody = commentBody;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	@Override
	public String toString() {
		return "PostComment{" +
				"id='" + id + '\'' +
				", commentBody='" + commentBody + '\'' +
				", commentDate=" + commentDate +
				'}';
	}
}
