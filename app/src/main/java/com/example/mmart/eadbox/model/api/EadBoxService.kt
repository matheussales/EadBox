package com.example.mmart.eadbox.model.api

import com.example.mmart.eadbox.model.Course
import io.reactivex.Observable
import retrofit2.http.GET

interface EadBoxService {

    @GET("courses")
    fun listCourses() : Observable<List<Course>>

}