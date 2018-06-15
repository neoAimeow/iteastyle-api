package com.aimeow.iteastyle.service;

import java.util.List;

import com.aimeow.iteastyle.domain.GetPostsResult;
import com.aimeow.iteastyle.domain.PostVO;
import com.aimeow.iteastyle.domain.Result;

public interface PostService {
    GetPostsResult getPosts(
        Integer page, Integer pageSize
    );

    Result<PostVO> getPostByPostId(
        String postId
    );
}
