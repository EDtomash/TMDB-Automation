package com.tmdb.pojo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestToken {
    private String request_token;
}
