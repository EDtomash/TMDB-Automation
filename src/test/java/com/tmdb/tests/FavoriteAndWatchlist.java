package com.tmdb.tests;

import com.tmdb.pojo.favoritemovie.FavoriteMovie;
import com.tmdb.utils.DataLoader;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.tmdb.api.CommonRequestActions.getRequest;
import static com.tmdb.api.CommonRequestActions.postRequest;
import static com.tmdb.api.Routes.*;
import static com.tmdb.api.TokenManager.getSessionId;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.testng.Assert.assertNotNull;

public class FavoriteAndWatchlist {
    public String sessionId;
    public int movieId = 550;

    @BeforeClass
    public void setup() {
        sessionId = getSessionId();
        System.out.println("====================");
        System.out.println("Session ID retrieval");
        System.out.println("====================");
        assertNotNull(sessionId, "Session ID should not be null");
    }

    @Test
    public void getAccountDetails() {
       Response response = getRequest(ACCOUNT + "/" + DataLoader.getInstance().getUserId(), sessionId);
       assertThat(response.statusCode(), equalTo(200));
       assertThat(response.path("username"), equalTo(DataLoader.getInstance().getUserLogin()));
    }

    @Test
    public void addingMovieToFavorite() {
        FavoriteMovie favoriteMovie = favoriteMovieBuilder("movie", movieId, true);
        Response response = postRequest(ACCOUNT + "/" + DataLoader.getInstance().getUserId() + FAVORITE, sessionId, favoriteMovie);

        assertThat(response.statusCode(), equalTo(201));
        assertThat(response.path("success"), equalTo(true));
        assertThat(response.path("status_message"), equalTo("The item/record was updated successfully."));
    }

    @Test
    public void getListWithFavoriteMovies() {
        Response response = getRequest(ACCOUNT + "/" + DataLoader.getInstance().getUserId() + FAVORITE + MOVIES, sessionId);
        assertThat(response.statusCode(), equalTo(200));
        assertThat(response.path("results.id"), hasItem(movieId));
    }

    public FavoriteMovie favoriteMovieBuilder(String mediaType, int mediaId, boolean favorite) {
       return  FavoriteMovie.builder()
                .media_type(mediaType)
                .media_id(mediaId)
                .favorite(favorite)
                .build();
    }
}
