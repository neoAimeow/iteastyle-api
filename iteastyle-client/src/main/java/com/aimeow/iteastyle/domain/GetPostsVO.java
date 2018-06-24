package com.aimeow.iteastyle.domain;

import java.util.List;

import lombok.Data;

@Data
public class GetPostsVO {
    private Integer page;
    private Integer pageSize;
    private Long totalCount;
    private String postBackgroundImage;
    private List<PostVO> posts;
}
