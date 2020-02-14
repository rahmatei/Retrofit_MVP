package com.example.test_mvp_retrofit.OghatSharei

import java.util.*
import java.util.zip.DataFormatException

class Sharei_Present(private val view:Sharei_Contract.View):Sharei_Contract.Presenter {

    private val model= Sharei_Model(this)

    override fun OnBtnSubmitOghat(){
        val(county,city)=view.getDataSharei()
        model.getShareiData(city,county,"8")
    }

    override fun SuccessGetData(sunset: String, sunrise: String, maghrib: String) {
        view.ShowDataSharei(sunset,sunrise,maghrib)
    }

    override fun GetDateTimeHours(): Int {
        return model.getHour().toInt()
    }

    override fun ErrorGetData() {
        view.ShowErrorGetData()
    }

}