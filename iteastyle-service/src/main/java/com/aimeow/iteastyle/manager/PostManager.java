package com.aimeow.iteastyle.manager;

import java.util.List;

import com.aimeow.iteastyle.domain.PostBO;

public interface PostManager {

    List<PostBO> getPosts(
        Integer status , Integer page , Integer pageSize
    ) throws Exception;

    PostBO getPostById(String postId) throws Exception;

    Boolean createPost(PostBO postBO) throws Exception;
    Boolean updatePost(PostBO postBO) throws Exception;
    Boolean deletePost(String postId) throws Exception;
}
