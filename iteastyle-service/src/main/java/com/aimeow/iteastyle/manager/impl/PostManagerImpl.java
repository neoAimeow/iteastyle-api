package com.aimeow.iteastyle.manager.impl;

import java.util.ArrayList;
import java.util.List;

import com.aimeow.iteastyle.converter.PostConverter;
import com.aimeow.iteastyle.dao.PostDAO;
import com.aimeow.iteastyle.domain.PostBO;
import com.aimeow.iteastyle.domain.PostDO;
import com.aimeow.iteastyle.domain.Result;
import com.aimeow.iteastyle.domain.query.PostQuery;
import com.aimeow.iteastyle.manager.PostManager;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostManagerImpl implements PostManager {

    @Autowired private PostDAO postDAO;

    @Override public Result<List<PostBO>> getPosts(
        @NonNull Integer status, Integer page, Integer pageSize
    ) throws Exception {
        Result<List<PostBO>> result = new Result<>();
        PostQuery query = new PostQuery();
        query.setPage((page==null || page==0)?1:page);
        query.setPageSize((pageSize==null || pageSize==0)?10:pageSize);
        query.setStartRow((page-1) * pageSize);
        query.setStatus(status);
        List<PostBO> postBOS = new ArrayList<>();
        List<PostDO> postDOS = postDAO.queryPosts(query);
        postDOS.iterator().forEachRemaining(
            obj->{
                postBOS.add(PostConverter.convertDTB(obj));
            }
        );
        result.setModel(postBOS);
        return result;
    }

    @Override public Result<PostBO> getPostById(
        @NonNull String postId) throws Exception {
        Result<PostBO> result = new Result<>();
        PostQuery query = new PostQuery();
        query.setPostId(postId);
        result.setModel(PostConverter
            .convertDTB(postDAO.queryPostById(query)));
        return result;
    }

    @Override public Result<Boolean> createPost(
        @NonNull PostBO postBO) throws Exception {
        Result<Boolean> result = new Result<>();
        result.setModel(postDAO.createPost(
            PostConverter.convertBTD(postBO)));
        return result;
    }

    @Override public Result<Boolean> updatePost(
        @NonNull PostBO postBO) throws Exception {
        Result<Boolean> result = new Result<>();
        result.setModel(postDAO.updatePost(
            PostConverter.convertBTD(postBO)));
        return result;
    }

    @Override public Result<Boolean> deletePost(
        @NonNull String postId) throws Exception {
        Result<Boolean> result = new Result<>();
        result.setModel(postDAO.deletePostById(
            postId));
        return result;
    }
}
