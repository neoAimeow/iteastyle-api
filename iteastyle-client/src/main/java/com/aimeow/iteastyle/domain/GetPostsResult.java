package com.aimeow.iteastyle.domain;

import java.util.List;

import lombok.Data;

@Data
public class GetPostsResult extends Result {
    private Integer page;
    private Integer pageSize;
    private Integer totalCount;
    private List<PostVO> posts;
}
