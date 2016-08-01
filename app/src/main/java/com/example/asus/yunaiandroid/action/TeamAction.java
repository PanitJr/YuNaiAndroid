package com.example.asus.yunaiandroid.action;

import com.example.asus.yunaiandroid.entity.Team;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by CAMT on 1/8/2559.
 */
public class TeamAction {
    public interface Caller {
        @POST("/teams/{day}/{hour}/{minute}")
        Call<Team> createTeam(@Body Team team,
                              @Path("day") Integer day,
                              @Path("hour") Integer hour,
                              @Path("minute") Integer minute);

        @GET("/teams/search/name/{name}")
        Call<List<Team>> searchTeam(@Path("name") String name);

        @POST("/teams/join/{teamName}")
        Call<Team> join(@Body String password, @Body Long userId, @Path("teamName") String teamName);
    }
}
