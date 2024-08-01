package com.tmdb.pojo.accountdetail;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Root {
    private Avatar avatar;
    private Integer id;
    private String iso_639_1;
    private String iso_3166_1;
    private String name;
    private Boolean include_adult;
    private String username;
}
