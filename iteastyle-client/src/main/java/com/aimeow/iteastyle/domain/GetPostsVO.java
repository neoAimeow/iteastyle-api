package com.aimeow.iteastyle.domain;

import java.util.List;

import lombok.Data;

@Data
public class GetPostsVO {
    private Integer page;
    private Integer pageSize;
    private Integer totalCount;
    private List<PostVO> posts;
}
