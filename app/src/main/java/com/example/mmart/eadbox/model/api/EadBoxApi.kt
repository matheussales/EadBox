package com.example.mmart.eadbox.model.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class EadBoxApi {

    private val retrofit = Retrofit.Builder()
                .baseUrl("http://matheus-martins.eadbox.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()


    fun eadboxService() = retrofit.create(EadBoxService::class.java)


}