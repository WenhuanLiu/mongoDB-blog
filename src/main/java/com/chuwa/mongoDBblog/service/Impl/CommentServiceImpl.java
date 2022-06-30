package com.chuwa.mongoDBblog.service.Impl;

import com.chuwa.mongoDBblog.dao.CommentRepository;
import com.chuwa.mongoDBblog.dao.PostRepository;
import com.chuwa.mongoDBblog.entity.Comment;
import com.chuwa.mongoDBblog.entity.Post;
import com.chuwa.mongoDBblog.exception.BlogAPIException;
import com.chuwa.mongoDBblog.payload.CommentDto;
import com.chuwa.mongoDBblog.service.CommentService;
import org.bson.types.ObjectId;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.chuwa.mongoDBblog.exception.ResourceNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName CommentServiceImpl
 * @Description TODO
 * @Author wenhu
 * @Date 6/27/2022 3:44 AM
 * @Version 1.0
 **/
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CommentDto createComment(ObjectId postId, CommentDto commentDto) {
        Comment comment = modelMapper.map(commentDto,Comment.class);
        //retrieve post entity by id
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
        //set post to comment entity
        comment.setPost(post);

        //comment entity to DB
        Comment savedComment = commentRepository.save(comment);
        return modelMapper.map(savedComment, CommentDto.class);
    }

    @Override
    public List<CommentDto> getCommentsByPostId(ObjectId postId) {
        //retrieve comments by postId
        List<Comment> comments = commentRepository.findByPostId(postId);

        //convert list of comment entities to list of comment dto's
        return comments.stream().map(comment -> modelMapper.map(comment,CommentDto.class)).collect(Collectors.toList());
    }

    @Override
    public CommentDto getCommentById(ObjectId postId, ObjectId commentId) {
        //retrieve post entity by id
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post","id", postId));

        //retrieve comment by id
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment", "id", commentId));

        //业务逻辑
        if(!comment.getPost().getId().equals(post.getId())){
            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Comment does not belong to post");
        }
        //return mapToDto(comment);
        return modelMapper.map(comment, CommentDto.class);
    }

    @Override
    public CommentDto updateComment(ObjectId postId, ObjectId commentId, CommentDto commentDtoRequest) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));

        //retrieve comment by id
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment", "id", commentId));

        //业务逻辑
        if(!comment.getPost().getId().equals(post.getId())){
            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Comment does not belong to post");
        }
        comment.setName(commentDtoRequest.getName());
        comment.setEmail(commentDtoRequest.getEmail());
        comment.setBody(commentDtoRequest.getBody());

        Comment updatedComment = commentRepository.save(comment);
        //return mapToDto(updatedComment);
        return modelMapper.map(updatedComment, CommentDto.class);
    }

    @Override
    public void deleteComment(ObjectId postId, ObjectId commentId) {
        //retrieve post entity by id
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));

        //retrieve comment by id
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment", "id", commentId));

        if(!comment.getPost().getId().equals(post.getId())){
            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Comment does not belong to post");
        }

        commentRepository.delete(comment);
    }
//
//    private CommentDto mapToDto(Comment comment){
//        CommentDto commentDto = new CommentDto();
//        commentDto.setId(comment.getId());
//        commentDto.setName(comment.getName());
//        commentDto.setEmail(comment.getEmail());
//        commentDto.setBody(comment.getBody());
//
//        return commentDto;
//    }
//
//    private Comment mapToEntity(CommentDto commentDto){
//        Comment comment = new Comment();
//        comment.setId(commentDto.getId());
//        comment.setName(commentDto.getName());
//        comment.setEmail(commentDto.getEmail());
//        comment.setBody(commentDto.getBody());
//
//        return comment;
//    }
}
