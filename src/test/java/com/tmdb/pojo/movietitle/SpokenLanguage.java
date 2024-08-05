package com.tmdb.pojo.movietitle;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SpokenLanguage {
    private String english_name;
    private String iso_639_1;
    private String name;
}
