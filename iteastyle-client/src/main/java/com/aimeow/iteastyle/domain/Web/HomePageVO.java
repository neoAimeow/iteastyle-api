package com.aimeow.iteastyle.domain.Web;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class HomePageVO {
    private List<String> headerImages;
    private List<String> serviceImages;
    private List<Map<String,String>> serviceWapInfos;
    private List<String> showerImages;
}
