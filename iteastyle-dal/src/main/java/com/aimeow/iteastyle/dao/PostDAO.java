package com.aimeow.iteastyle.dao;

import java.util.List;

import com.aimeow.iteastyle.domain.PostDO;

public interface PostDAO {
    List<PostDO> queryPosts() throws Exception;
    PostDO queryPostById() throws Exception;
    Boolean createPost(PostDO postDO) throws Exception;
    Boolean updatePost(PostDO postDO) throws Exception;
    Boolean deletePostById(String postId) throws Exception;
}
