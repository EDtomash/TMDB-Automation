package com.tmdb.pojo.movietitle;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;

@Data
@Builder
public class Root {
    private Boolean adult;
    private String backdrop_path;
    private Object belongs_to_collection;
    private Integer budget;
    private ArrayList<Genre> genres;
    private String homepage;
    private Integer id;
    private String imdb_id;
    private ArrayList<String> origin_country;
    private String original_language;
    private String original_title;
    private String overview;
    private Double popularity;
    private String poster_path;
    private ArrayList<ProductionCompany> production_companies;
    private ArrayList<ProductionCountry> production_countries;
    private String release_date;
    private Integer revenue;
    private Integer runtime;
    private ArrayList<SpokenLanguage> spoken_languages;
    private String status;
    private String tagline;
    private String title;
    private Boolean video;
    private Double vote_average;
    private Integer vote_count;
}
