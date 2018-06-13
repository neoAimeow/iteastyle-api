package com.aimeow.iteastyle.service.impl;

import java.util.List;

import com.aimeow.iteastyle.domain.PostVO;
import com.aimeow.iteastyle.domain.Result;
import com.aimeow.iteastyle.service.PostService;
import lombok.NonNull;

public class PostServiceImpl implements PostService {
    @Override
    public Result<List<PostVO>> getPosts(
        Integer page, Integer pageSize) {
        return null;
    }

    @Override
    public Result<PostVO> getPostByPostId(
        @NonNull String postId) {
        return null;
    }
}
