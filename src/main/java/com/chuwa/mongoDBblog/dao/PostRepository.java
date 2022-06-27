package com.chuwa.mongoDBblog.dao;

import com.chuwa.mongoDBblog.entity.Post;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @ClassName PostRepository
 * @Description TODO
 * @Author wenhu
 * @Date 6/24/2022 4:00 PM
 * @Version 1.0
 **/
@Repository
public interface PostRepository extends MongoRepository<Post, ObjectId> {
}
