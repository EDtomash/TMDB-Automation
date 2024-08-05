package com.tmdb.pojo.movietitle;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductionCountry {
    private String iso_3166_1;
    private String name;
}
