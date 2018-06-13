package com.aimeow.iteastyle.manager.impl;

import java.util.List;

import com.aimeow.iteastyle.domain.PostBO;
import com.aimeow.iteastyle.manager.PostManager;
import lombok.NonNull;

public class PostManagerImpl implements PostManager {

    @Override public List<PostBO> getPosts(
        @NonNull Integer status, Integer page, Integer pageSize
    ) throws Exception {
        return null;
    }

    @Override public PostBO getPostById(
        @NonNull String postId) throws Exception {
        return null;
    }

    @Override public Boolean createPost(
        @NonNull PostBO postBO) throws Exception {
        return null;
    }

    @Override public Boolean updatePost(
        @NonNull PostBO postBO) throws Exception {
        return null;
    }

    @Override public Boolean deletePost(
        @NonNull String postId) throws Exception {
        return null;
    }
}
