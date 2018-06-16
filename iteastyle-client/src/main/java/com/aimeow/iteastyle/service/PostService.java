package com.aimeow.iteastyle.service;

import java.util.List;

import com.aimeow.iteastyle.domain.GetPostsResult;
import com.aimeow.iteastyle.domain.PostVO;
import com.aimeow.iteastyle.domain.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface PostService {
    @RequestMapping("/post/getPosts")
    GetPostsResult getPosts(
        Integer page, Integer pageSize
    );
    @RequestMapping("/post/getPostById")
    Result<PostVO> getPostByPostId(
        String postId
    );
}
