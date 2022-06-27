package com.chuwa.mongoDBblog.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

/**
 * @ClassName Comment
 * @Description TODO
 * @Author wenhu
 * @Date 6/27/2022 3:18 AM
 * @Version 1.0
 **/
@Document
public class Comment {

    @Id
    private ObjectId id;
    @Field
    private String name;
    @Field
    private String email;
    @Field
    private String body;

    private Post post;

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @CreatedDate
    private LocalDate createDateTime;

    private LocalDate updateDateTime;

    public Comment() {
    }

    public Comment(ObjectId id, String name, String email, String body) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.body = body;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDate createDateTime) {
        this.createDateTime = createDateTime;
    }

    public LocalDate getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(LocalDate updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
