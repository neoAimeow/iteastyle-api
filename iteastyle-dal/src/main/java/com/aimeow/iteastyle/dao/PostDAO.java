package com.aimeow.iteastyle.dao;

import java.util.List;

import com.aimeow.iteastyle.domain.PostDO;
import com.aimeow.iteastyle.domain.query.PostQuery;

public interface PostDAO {
    List<PostDO> queryPosts(
        PostQuery query) throws Exception;
    PostDO queryPostById(
        PostQuery query) throws Exception;
    Integer countPosts(
        PostQuery query) throws Exception;
    Boolean createPost(
        PostDO postDO) throws Exception;
    Boolean updatePost(
        PostDO postDO) throws Exception;
    Boolean deletePostById(
        String postId) throws Exception;
}
