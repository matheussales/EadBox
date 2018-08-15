package com.example.mmart.eadbox.model.api

import com.example.mmart.eadbox.model.Course
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class EadBoxApi {

    private val eadBoxService : EadBoxService

    init {

        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)

        val retrofit = Retrofit.Builder()
                .baseUrl("http://matheus-martins.eadbox.com/api/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build()

        eadBoxService = retrofit.create<EadBoxService>(EadBoxService::class.java)
    }

    fun loadCourses(): Observable<Course>? {
        return eadBoxService.listCourses()
                .flatMap{ courses -> Observable.fromIterable(courses)}
                .map { course -> Course(course.title, course.category, course.workload, course.logo, course.lectures) }
    }
}