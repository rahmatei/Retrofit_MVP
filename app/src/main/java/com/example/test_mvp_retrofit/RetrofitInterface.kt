package com.example.test_mvp_retrofit

import com.example.test_mvp_retrofit.PojoClass.AladhanResponseModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitInterface {
    @GET("timingsByCity")
    fun GetSharei(
        @Query("city") city: String,
        @Query("country") county: String,
        @Query("method") method: String
    ):Call<AladhanResponseModel>
}