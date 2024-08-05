package com.tmdb.pojo.watchlistmovie;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WachlistMovie {
    private String media_type;
    private Integer media_id;
    private Boolean watchlist;
}
