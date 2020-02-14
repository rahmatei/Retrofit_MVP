package com.example.test_mvp_retrofit.OghatSharei

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.test_mvp_retrofit.R
import kotlinx.android.synthetic.main.activity_sharei_.*

class Sharei_Activity : AppCompatActivity(), Sharei_Contract.View {

    val Presenter: Sharei_Contract.Presenter = Sharei_Present(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sharei_)
        val a = GetTimeHours()
        Toast.makeText(this,a.toString(),Toast.LENGTH_LONG).show()


        btnSubmit.setOnClickListener {
            Presenter.OnBtnSubmitOghat()
        }
    }

    override fun getDataSharei(): Pair<String, String> {
        val City = EdtCity.text.toString()
        val Country = EdtCountry.text.toString()
        return City to Country
    }

    override fun ShowErrorGetData() {
        Toast.makeText(this, "خطا در دریافت اطلاعات", Toast.LENGTH_LONG).show();
    }

    override fun ShowDataSharei(sunset: String, sunrise: String, maghrib: String) {
        txtsunset.text = sunset.toString()
        txtsunrise.text = sunrise.toString()
        txtmaghrib.text = maghrib.toString()
    }

    override fun GetTimeHours() {
        Presenter.GetDateTimeHours()
    }
}
