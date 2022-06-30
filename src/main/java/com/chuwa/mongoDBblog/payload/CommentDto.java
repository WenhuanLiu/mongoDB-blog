package com.chuwa.mongoDBblog.payload;

import org.bson.types.ObjectId;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Objects;


/**
 * @ClassName CommentDto
 * @Description TODO
 * @Author wenhu
 * @Date 6/27/2022 3:39 AM
 * @Version 1.0
 **/
public class CommentDto {

    private ObjectId id;

    @NotEmpty(message = "Name should not be null or empty")
    private String name;
    @NotEmpty(message = "email should not be null or empty")
    @Email
    private String email;
    @NotEmpty
    @Size(min = 5, message = "Comment body must be minimum 5 characters")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CommentDto)) {
            return false;
        }
        CommentDto that = (CommentDto) o;
        return getId() == that.getId() && getName().equals(that.getName()) && getEmail().equals(that.getEmail()) && getBody().equals(that.getBody());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getEmail(), getBody());
    }
}
