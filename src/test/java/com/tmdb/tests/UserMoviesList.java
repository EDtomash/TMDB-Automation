package com.tmdb.tests;

import com.tmdb.pojo.mediaid.MediaId;
import com.tmdb.pojo.usermovieslist.UserList;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.tmdb.api.CommonRequestActions.*;
import static com.tmdb.api.Routes.*;
import static com.tmdb.api.TokenManager.getSessionId;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertNotNull;

public class UserMoviesList {
    public String sessionId;
    public Integer listId;
    public MediaId mediaId;

    @BeforeClass
    public void setup() {
        sessionId = getSessionId();
        System.out.println("====================");
        System.out.println("Session ID retrieval");
        System.out.println("====================");
        assertNotNull(sessionId, "Session ID should not be null");
    }

    @Test
    public void creatingListOfUserMovies() {
        UserList userList = UserList.builder()
                .name("Zalupa")
                .description("Stas")
                .language("en")
                .build();

        Response response = postRequest(LIST, sessionId, userList);
        listId = response.path("list_id");
        assertThat(response.statusCode(), equalTo(201));
        assertThat(response.path("success"), equalTo(true));
        assertThat(response.path("status_message"), equalTo("Success."));
    }

    @Test(dependsOnMethods = "creatingListOfUserMovies")
    public void addingMovieToList() {
        MediaId mediaId = new MediaId(18);
        Response response = postRequest(LIST + "/" + listId + "/add_item", sessionId, mediaId);

        assertThat(response.statusCode(), equalTo(201));
        assertThat(response.path("success"), equalTo(true));
        assertThat(response.path("status_message"), equalTo("The item/record was updated successfully."));
    }

    @Test(dependsOnMethods = "addingMovieToList")
    public void checkAddedMovieToList() {
        Response response = getWithQueryRequest(LIST + "/" + listId + ITEM_STATUS, sessionId, "movie_id", "18");

        assertThat(response.statusCode(), equalTo(200));
        assertThat(response.path("item_present"), equalTo(true));
    }
//
//    @Test(dependsOnMethods = "addingMovieToList")
//    public void removingMovieFromList() {
//        Response response = postRequest(LIST + "/" + listId + REMOVE_ITEM, sessionId,  );
////        assertThat(response.statusCode(), equalTo());
//    }
}
