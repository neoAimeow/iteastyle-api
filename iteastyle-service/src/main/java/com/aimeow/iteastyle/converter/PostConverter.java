package com.aimeow.iteastyle.converter;

import com.aimeow.iteastyle.domain.PostBO;
import com.aimeow.iteastyle.domain.PostDO;
import com.aimeow.iteastyle.domain.Post.PostVO;

public class PostConverter {
    public static PostBO convertDTB(PostDO postDO) {
        PostBO postBO = new PostBO();
        postBO.setId(postDO.getId());
        postBO.setStatus(postDO.getStatus());
        postBO.setTitle(postDO.getTitle());
        postBO.setGmtCreate(postDO.getGmtCreate());
        postBO.setGmtModified(postDO.getGmtModified());
        postBO.setContent(postDO.getContent());
        return postBO;
    }

    public static PostDO convertBTD(PostBO postBO) {
        PostDO postDO = new PostDO();
        postDO.setId(postBO.getId());
        postDO.setStatus(postBO.getStatus());
        postDO.setTitle(postBO.getTitle());
        postDO.setGmtCreate(postBO.getGmtCreate());
        postDO.setGmtModified(postBO.getGmtModified());
        postDO.setContent(postBO.getContent());
        return postDO;
    }

    public static PostVO convertBTV(PostBO postBO) {
        PostVO postVO = new PostVO();
        postVO.setId(postBO.getId());
        postVO.setStatus(postBO.getStatus());
        postVO.setTitle(postBO.getTitle());
        postVO.setGmtCreate(postBO.getGmtCreate());
        postVO.setGmtModified(postBO.getGmtModified());
        postVO.setContent(postBO.getContent());
        return postVO;
    }
}
