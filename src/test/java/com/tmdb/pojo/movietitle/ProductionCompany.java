package com.tmdb.pojo.movietitle;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductionCompany {
    private Integer id;
    private Object logo_path;
    private String name;
    private String origin_country;
}
