package com.tmdb.pojo.usermovieslist;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserList {
    private String name;
    private String description;
    private String language;
}
