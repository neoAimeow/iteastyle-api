package com.aimeow.iteastyle.dao.impl;

import java.util.Date;
import java.util.List;

import com.aimeow.iteastyle.dao.PostDAO;
import com.aimeow.iteastyle.domain.PostDO;
import com.aimeow.iteastyle.domain.query.PostQuery;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

@Component
public class PostDAOImpl implements PostDAO {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override public List<PostDO> queryPosts(
        @NonNull PostQuery postQuery
    ) throws Exception {
        Query query=new Query(Criteria.where("status").is(
                postQuery.getStatus()));
        List<PostDO> postDOS =  mongoTemplate.find(
                query , PostDO.class
        );
        return postDOS;
    }

    @Override public PostDO queryPostById(
        @NonNull PostQuery postQuery
    ) throws Exception {
        Query query=new Query(Criteria.where("id").is(
                postQuery.getPostId()));
        PostDO post =  mongoTemplate.findOne(
                query , PostDO.class
        );
        return post;
    }

    @Override public Long countPosts(
        @NonNull PostQuery postQuery) throws Exception {
        Query query=new Query(Criteria.where("status").is(
                postQuery.getStatus()));
        return mongoTemplate.count(query, PostDO.class);
    }

    @Override public Boolean createPost(
        @NonNull PostDO postDO
    ) throws Exception {
        postDO.setGmtCreate(new Date());
        postDO.setGmtModified(new Date());
        mongoTemplate.save(postDO);
        return true;
    }

    @Override public Boolean updatePost(
        @NonNull PostDO postDO
    ) throws Exception {
        postDO.setGmtModified(new Date());
        Query query=new Query(Criteria.where(
            "id").is(postDO.getId()));

        Update update= new Update()
            .set("title", postDO.getTitle())
            .set("content", postDO.getContent());

        mongoTemplate.updateFirst(query,update,PostDO.class);
        return true;
    }

    @Override public Boolean deletePostById(
        @NonNull String postId) throws Exception {
        Query query=new Query(Criteria.where("id").is(postId));
        mongoTemplate.remove(query,PostDO.class);
        return true;
    }
}