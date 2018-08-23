package com.charles.overstack.posts.domain.models;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Document(collection = "posts")
public class Post {

	@Id
	private String id;

	private String title;
	private String postBody;
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date postDate;

	public Post() {}

	public Post(String title, String postBody, Date postDate) {
		this.title = title;
		this.postBody = postBody;
		this.postDate = postDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPostBody() {
		return postBody;
	}

	public void setPostBody(String postBody) {
		this.postBody = postBody;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	@Override
	public String toString() {
		return "Post{" +
				"id='" + id + '\'' +
				", title='" + title + '\'' +
				", postBody='" + postBody + '\'' +
				", postDate=" + postDate +
				'}';
	}
}
