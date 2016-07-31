package com.example.asus.yunaiandroid.action;

import com.example.asus.yunaiandroid.entity.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Asus on 1/8/2559.
 */
public class UserAction {
    public interface Caller {
        @POST("/users")
        Call<User> createUser(@Body User user);
    }
}
