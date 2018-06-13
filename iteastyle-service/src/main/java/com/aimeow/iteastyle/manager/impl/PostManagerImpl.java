package com.aimeow.iteastyle.manager.impl;

import java.util.List;

import com.aimeow.iteastyle.dao.PostDAO;
import com.aimeow.iteastyle.domain.PostBO;
import com.aimeow.iteastyle.domain.Result;
import com.aimeow.iteastyle.manager.PostManager;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;

public class PostManagerImpl implements PostManager {

    @Autowired private PostDAO postDAO;

    @Override public Result<List<PostBO>> getPosts(
        @NonNull Integer status, Integer page, Integer pageSize
    ) throws Exception {
        Result<List<PostBO>> result = new Result<>();

        return result;
    }

    @Override public Result<PostBO> getPostById(
        @NonNull String postId) throws Exception {
        Result<PostBO> result = new Result<>();

        return result;
    }

    @Override public Result<Boolean> createPost(
        @NonNull PostBO postBO) throws Exception {
        Result<Boolean> result = new Result<>();
        return result;
    }

    @Override public Result<Boolean> updatePost(
        @NonNull PostBO postBO) throws Exception {
        Result<Boolean> result = new Result<>();
        return result;
    }

    @Override public Result<Boolean> deletePost(
        @NonNull String postId) throws Exception {

        Result<Boolean> result = new Result<>();
        return result;
    }
}
