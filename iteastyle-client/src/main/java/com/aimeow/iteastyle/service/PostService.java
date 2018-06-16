package com.aimeow.iteastyle.service;

import java.util.List;

import com.aimeow.iteastyle.domain.GetPostsVO;
import com.aimeow.iteastyle.domain.PostVO;
import com.aimeow.iteastyle.domain.Result;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Post", description = "茶式动态接口")
@RestController
public interface PostService {
    @RequestMapping(value = "/post/getPosts", method = RequestMethod.GET, consumes="application/json")
    Result<GetPostsVO> getPosts(
        Integer page, Integer pageSize
    );

    @RequestMapping(value = "/post/getPostById", method = RequestMethod.GET, consumes="application/json")
    Result<PostVO> getPostByPostId(
        String postId
    );
}
