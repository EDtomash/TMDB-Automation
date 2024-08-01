package com.tmdb.pojo.accountdetail;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Gravatar {
    private String hash;
}
