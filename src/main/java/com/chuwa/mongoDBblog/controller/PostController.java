package com.chuwa.mongoDBblog.controller;

import com.chuwa.mongoDBblog.payload.PostDto;
import com.chuwa.mongoDBblog.payload.PostResponse;
import com.chuwa.mongoDBblog.service.PostService;
import com.chuwa.mongoDBblog.utils.AppConstants;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName PostController
 * @Description TODO
 * @Author wenhu
 * @Date 6/24/2022 4:10 PM
 * @Version 1.0
 **/
@RestController
@RequestMapping("/api/v1")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/posts")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
        PostDto postResponse = postService.createPost(postDto);
        return new ResponseEntity<>(postResponse, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable(name = "id") ObjectId id){
        return ResponseEntity.ok(postService.getPostById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto,@PathVariable(name = "id") ObjectId id ){
        PostDto postResponse = postService.updatePost(postDto,id);
        return new ResponseEntity<>(postResponse,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePostById(@PathVariable(name = "id") ObjectId id){
        postService.deletePostById(id);
        return new ResponseEntity<>("Post entity deleted successfully", HttpStatus.OK);
    }

    @GetMapping
    public PostResponse getAllPostsInfo(
            @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIR, required = false) String sortDir
    ) {
        return postService.getAllPost(pageNo, pageSize, sortBy, sortDir);
    }
}
