package com.tmdb.tests;

import com.tmdb.pojo.movierating.MovieRating;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.tmdb.api.CommonRequestActions.*;
import static com.tmdb.api.Routes.MOVIE;
import static com.tmdb.api.Routes.RATING;
import static com.tmdb.api.TokenManager.getSessionId;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.either;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertNotNull;

public class MovieRatingCrud {
    public String sessionId;
    public int movieId = 68;

    @BeforeClass
    public void setup() {
        sessionId = getSessionId();
        System.out.println("====================");
        System.out.println("Session ID retrieval");
        System.out.println("====================");
        assertNotNull(sessionId, "Session ID should not be null");
    }

    @Test
    public void getMovieById() {
        Response response = getRequest(MOVIE + "/" + movieId, sessionId);
        assertThat(response.statusCode(), equalTo(200));
        assertThat(response.path("id"), equalTo(movieId));
    }

    @Test
    public void ratingMovieById() {
        MovieRating movieRating = MovieRating.builder()
                    .value(5.5)
                    .build();

        Response response = postRequest(MOVIE + "/" + movieId + RATING, sessionId, movieRating);
        assertThat(response.statusCode(), equalTo(201));
        assertThat(response.path("status_message"), equalTo("The item/record was updated successfully."));
        }

    @Test
    public void deletingMovieById() {
        Response response = deleteRequest(MOVIE + "/" + movieId + RATING, sessionId);
        assertThat(response.statusCode(), equalTo(200));
        assertThat(response.path("status_message"), either(equalTo("The item/record was deleted successfully."))
                .or(equalTo("Success.")));
    }
}
