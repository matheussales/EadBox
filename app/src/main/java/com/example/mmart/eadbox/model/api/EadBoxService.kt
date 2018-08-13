package com.example.mmart.eadbox.model.api

import com.example.mmart.eadbox.model.Course
import retrofit2.Call
import retrofit2.http.GET

interface EadBoxService {

    @GET("courses")
    fun listCourses() : Call<List<Course>>
}