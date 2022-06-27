package com.chuwa.mongoDBblog.dao;

import com.chuwa.mongoDBblog.entity.Comment;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName CommentRepository
 * @Description TODO
 * @Author wenhu
 * @Date 6/27/2022 3:37 AM
 * @Version 1.0
 **/
@Repository
public interface CommentRepository extends MongoRepository<Comment, ObjectId> {

    List<Comment> findByPostId(ObjectId posyId);
}
