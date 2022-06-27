package com.chuwa.mongoDBblog.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

/**
 * @ClassName Post
 * @Description TODO
 * @Author wenhu
 * @Date 6/24/2022 3:49 PM
 * @Version 1.0
 **/
@Document("posts")
public class Post {

    @Id
    private ObjectId id;

    @Field
    private String title;
    @Field
    private String description;
    @Field
    private String content;

    @CreatedDate
    private LocalDate creatDatetime;
    private LocalDate updateDatetime;

    public Post() {
    }

    public Post(ObjectId id, String title, String description, String content, LocalDate creatDatetime, LocalDate updateDatetime) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.content = content;
        this.creatDatetime = creatDatetime;
        this.updateDatetime = updateDatetime;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getCreatDatetime() {
        return creatDatetime;
    }

    public void setCreatDatetime(LocalDate creatDatetime) {
        this.creatDatetime = creatDatetime;
    }

    public LocalDate getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(LocalDate updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                ", creatDatetime=" + creatDatetime +
                ", updateDatetime=" + updateDatetime +
                '}';
    }
}
