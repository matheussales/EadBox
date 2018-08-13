package com.example.mmart.eadbox.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.LinearLayout
import com.example.mmart.eadbox.R
import com.example.mmart.eadbox.model.Course
import com.example.mmart.eadbox.model.api.EadBoxApi
import com.example.mmart.eadbox.ui.adapter.ListVideosAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val call = EadBoxApi().eadboxService().listCourses()
        call.enqueue(object : Callback<List<Course>?> {
            override fun onFailure(call: Call<List<Course>?>?, t: Throwable?) {
                Log.e("onFailure error", t?.message)
            }

            override fun onResponse(call: Call<List<Course>?>?, response: Response<List<Course>?>?) {
                response?.body()?.let {
                    val courses: List<Course> = it

                    configureList(courses)
                }


            }
        })

    }

    private fun configureList(courses: List<Course>) {
        val recyclerView = recycler_view
        recyclerView.adapter = ListVideosAdapter(this, courses)
        recyclerView.layoutManager = LinearLayoutManager(this)

    }

//    private fun videos(): List<Course> {
//        return listOf<Course>(Course("Video 1"), Course("Video 2"))
//    }

}

