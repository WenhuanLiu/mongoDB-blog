package com.chuwa.mongoDBblog.payload;

import org.bson.types.ObjectId;

/**
 * @ClassName PostDto
 * @Description TODO
 * @Author wenhu
 * @Date 6/24/2022 4:02 PM
 * @Version 1.0
 **/
public class PostDto {

    private ObjectId id;
    private String title;
    private String description;
    private String content;

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

    @Override
    public String toString() {
        return "PostDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
