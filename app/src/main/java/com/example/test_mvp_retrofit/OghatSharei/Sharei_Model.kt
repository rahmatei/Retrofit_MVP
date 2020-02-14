package com.example.test_mvp_retrofit.OghatSharei

import com.example.test_mvp_retrofit.PojoClass.AladhanResponseModel
import com.example.test_mvp_retrofit.RetrofitInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

class Sharei_Model(val Presenter: Sharei_Contract.Presenter) {
    fun getShareiData(city: String, Country: String, Method: String) {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://api.aladhan.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val retrofitInterface= retrofit.create(RetrofitInterface::class.java)
        retrofitInterface.GetSharei(city,Country,Method).enqueue(object:Callback<AladhanResponseModel>{
            override fun onFailure(call: Call<AladhanResponseModel>, t: Throwable) {
                Presenter.ErrorGetData()
            }

            override fun onResponse(call: Call<AladhanResponseModel>, response: Response<AladhanResponseModel>) {
                val sunset = response.body()!!.data.timings.Sunset
                val sunrise = response.body()!!.data.timings.Sunrise
                val maghrib = response.body()!!.data.timings.Maghrib
                Presenter.SuccessGetData(sunset,sunrise,maghrib)
            }

        })
    }
    fun getHour():String{
        val date= Date()
        val hour = date.hours
        return hour.toString()
    }
}