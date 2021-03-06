package com.chuwa.mongoDBblog.controller;

import com.chuwa.mongoDBblog.payload.CommentDto;
import com.chuwa.mongoDBblog.service.CommentService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @ClassName CommentController
 * @Description TODO
 * @Author wenhu
 * @Date 6/27/2022 4:37 AM
 * @Version 1.0
 **/
@RestController
@RequestMapping("/api")
public class CommentController {
    /**
     * TODO: Questions
     * why intellij give us this warning? constructor injection.
     * how many ways we can do Dependency Injection?
     * which way is the best one?
     */
    @Autowired
    private CommentService commentService;

    /**
     * TODO: Questions
     * 当我们浏览小红书时候，点开一篇文章，请问获得这篇文章的内容，是用的哪个API？
     * 看到大家争论库里历史地位是否超越科比，你要写评论回应，当你的评论提交时候，会call哪个API？
     * <p>
     * 此时此刻，思考为什么post的ID是pathVariable 而不是request parameter?
     *
     * @param id
     * @param commentDto
     * @return
     */
    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<CommentDto> createComment(@PathVariable(value = "postId") ObjectId id,
                                                    @Valid @RequestBody CommentDto commentDto) {
        return new ResponseEntity<>(commentService.createComment(id, commentDto), HttpStatus.CREATED);
    }

    @GetMapping("/posts/{postId}/comments")
    public List<CommentDto> getCommentsByPostId(@PathVariable(value = "postId") ObjectId postId) {
        return commentService.getCommentsByPostId(postId);
    }

    @GetMapping("/posts/{postId}/comments/{id}")
    public ResponseEntity<CommentDto> getCommentsById(
            @PathVariable(value = "postId") ObjectId postId,
            @PathVariable(value = "id") ObjectId commentId) {

        CommentDto commentDto = commentService.getCommentById(postId, commentId);
        return new ResponseEntity<>(commentDto, HttpStatus.OK);
    }

    @PutMapping("/posts/{postId}/comments/{id}")
    public ResponseEntity<CommentDto> updateComment(@PathVariable(value = "postId") ObjectId postId,
                                                    @PathVariable(value = "id") ObjectId commentId,
                                                    @Valid@RequestBody CommentDto commentDto) {
        CommentDto updateComment = commentService.updateComment(postId, commentId, commentDto);
        return new ResponseEntity<>(updateComment, HttpStatus.OK);
    }

    @DeleteMapping("/posts/{postId}/comments/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable(value = "postId") ObjectId postId,
                                                @PathVariable(value = "id") ObjectId commentId) {
        commentService.deleteComment(postId, commentId);

        return new ResponseEntity<>("Comment deleted Successfully", HttpStatus.OK);
    }
}
