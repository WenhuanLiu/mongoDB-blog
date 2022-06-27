package com.chuwa.mongoDBblog.payload;

import org.bson.types.ObjectId;

/**
 * @ClassName CommentDto
 * @Description TODO
 * @Author wenhu
 * @Date 6/27/2022 3:39 AM
 * @Version 1.0
 **/
public class CommentDto {

    private ObjectId id;
    private String name;
    private String email;
    private String body;

    public CommentDto() {
    }

    public CommentDto(ObjectId id, String name, String email, String body) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "CommentDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
