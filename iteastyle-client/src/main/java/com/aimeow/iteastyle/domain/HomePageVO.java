package com.aimeow.iteastyle.domain;

import lombok.Data;

import java.util.List;

@Data
public class HomePageVO {
    private List<String> headerImages;
    private List<String> serviceImages;
    private List<String> showerImages;
}
