package com.aimeow.iteastyle.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.aimeow.iteastyle.converter.PostConverter;
import com.aimeow.iteastyle.domain.GetPostsVO;
import com.aimeow.iteastyle.domain.PostBO;
import com.aimeow.iteastyle.domain.PostVO;
import com.aimeow.iteastyle.domain.Result;
import com.aimeow.iteastyle.manager.PostManager;
import com.aimeow.iteastyle.service.PostService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostServiceImpl implements PostService {
    @Autowired private PostManager postManager;

    @Override
    public Result<GetPostsVO> getPosts(
        Integer page, Integer pageSize) {
        Result<GetPostsVO> result = new Result<GetPostsVO>();
        GetPostsVO getPostsVO = new GetPostsVO();
        try {
            List<PostVO> postVos = new ArrayList();
            List<PostBO> postBos = postManager.getPosts(
                    0 , page , pageSize).getModel();
            postBos.iterator().forEachRemaining(
                    obj-> {
                        postVos.add(PostConverter.convertBTV(obj));
                    }
            );
            getPostsVO.setPosts(postVos);
            result.setModel(getPostsVO);
        } catch (Exception e) {
            result.setSuccess(false);
            return result;
        }
        return result;
    }

    @Override
    public Result<PostVO> getPostByPostId(
        @NonNull String postId) {
        Result<PostVO> result = new Result<>();
        try {
            result.setModel(PostConverter.convertBTV(
                    postManager.getPostById(postId).getModel()));
        } catch (Exception e) {
            result.setSuccess(false);
            return result;
        }
        return result;
    }
}
