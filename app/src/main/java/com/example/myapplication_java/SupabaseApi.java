package com.example.myapplication_java;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface SupabaseApi {

    // READ users
    @GET("users")
    Call<List<User>> getUsers(@Query("select") String select);

    // INSERT users
    @Headers({
            "Prefer: return=representation",
            "Content-Type: application/json"
    })
    @POST("users")
    Call<List<User>> insertUsers(@Body List<User> users);
}
