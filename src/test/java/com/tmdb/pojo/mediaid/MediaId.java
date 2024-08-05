package com.tmdb.pojo.mediaid;

import lombok.Data;

@Data
public class MediaId {
    private Integer media_id;

    public MediaId(Integer mediaId) {
        this.media_id = mediaId;
    }
}
