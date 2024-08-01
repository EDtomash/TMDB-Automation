package com.tmdb.pojo.favoritemovie;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FavoriteMovie {
    private String media_type;
    private Integer media_id;
    private Boolean favorite;
}
