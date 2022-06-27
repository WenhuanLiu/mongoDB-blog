package com.chuwa.mongoDBblog.service;

import com.chuwa.mongoDBblog.payload.PostDto;
import com.chuwa.mongoDBblog.payload.PostResponse;
import org.bson.types.ObjectId;

import java.util.List;


/**
 * @ClassName PostService
 * @Description TODO
 * @Author wenhu
 * @Date 6/24/2022 4:03 PM
 * @Version 1.0
 **/
public interface PostService {

    PostDto createPost(PostDto postDto);

    List<PostDto> getAllPost();

    PostDto getPostById(ObjectId id);

    PostDto updatePost(PostDto postDto, ObjectId id);

    void deletePostById(ObjectId id);

    PostResponse getAllPost(int pageNo, int pageSize, String sortBy, String sortDir);
}
