package com.example.midterm_2018352;

import com.example.midterm_2018352.models.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface JsonAPI {
    @GET("posts/")
    Call<Result> getPosts(/*@Query("results") int id*/);
}
