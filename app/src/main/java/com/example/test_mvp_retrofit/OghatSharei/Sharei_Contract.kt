package com.example.test_mvp_retrofit.OghatSharei

interface Sharei_Contract {

    interface View{
        fun getDataSharei():Pair<String,String>
        fun ShowErrorGetData()
        fun ShowDataSharei(sunset:String,sunrise:String,maghrib:String)
        fun GetTimeHours(){}
    }
    interface Presenter{
        fun OnBtnSubmitOghat(){}
        fun ErrorGetData(){}
        fun SuccessGetData(sunset:String,sunrise:String,maghrib:String)
        fun GetDateTimeHours():Int
    }
}