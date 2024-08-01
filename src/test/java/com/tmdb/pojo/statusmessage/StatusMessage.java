package com.tmdb.pojo.statusmessage;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StatusMessage {
    private Boolean success;
    private Integer status_code;
    private String status_message;
}
