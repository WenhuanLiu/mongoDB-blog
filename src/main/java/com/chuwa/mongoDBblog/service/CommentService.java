package com.chuwa.mongoDBblog.service;

import com.chuwa.mongoDBblog.payload.CommentDto;
import org.bson.types.ObjectId;

import java.util.List;

/**
 * @ClassName CommentService
 * @Description TODO
 * @Author wenhu
 * @Date 6/27/2022 3:41 AM
 * @Version 1.0
 **/
public interface CommentService {

    CommentDto createComment(ObjectId postId, CommentDto commentDto);

    List<CommentDto> getCommentsByPostId(ObjectId postId);

    CommentDto getCommentById(ObjectId postId, ObjectId commentId);

    CommentDto updateComment(ObjectId postId, ObjectId commentId, CommentDto commentDtoRequest);

    void deleteComment(ObjectId postId, ObjectId commentId);

}
