package com.aimeow.iteastyle.domain.ViewObject;

import java.util.List;

import com.aimeow.iteastyle.domain.entity.PostEntity;
import lombok.Data;

@Data
public class GetPostsVO {
    private Integer page;
    private Integer pageSize;
    private Long totalCount;
    private String postBackgroundImage;
    private List<PostEntity> posts;
}
