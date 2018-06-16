package com.aimeow.iteastyle.manager;

import java.util.List;

import com.aimeow.iteastyle.domain.PostBO;
import com.aimeow.iteastyle.domain.Result;

public interface PostManager {

    Result<List<PostBO>> getPosts(
        Integer status , Integer page , Integer pageSize
    ) throws Exception;

    Result<PostBO> getPostById(String postId) throws Exception;
    Result<Boolean> createPost(PostBO postBO) throws Exception;
    Result<Boolean> updatePost(PostBO postBO) throws Exception;
    Result<Boolean> deletePost(String postId) throws Exception;
}
