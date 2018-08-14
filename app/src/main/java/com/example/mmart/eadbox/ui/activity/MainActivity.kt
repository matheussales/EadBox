package com.example.mmart.eadbox.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.mmart.eadbox.R
import com.example.mmart.eadbox.model.Course
import com.example.mmart.eadbox.model.api.EadBoxApi
import com.example.mmart.eadbox.ui.adapter.ListVideosAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var courses = mutableListOf<Course>()
    private val adapter = ListVideosAdapter(this, courses)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = recycler_view
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        val api = EadBoxApi()
        api.loadCourses()!!
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    course -> courses.add(Course(course.mTitle))
                }, {
                    e -> e.printStackTrace()
                }, {
                    adapter.notifyDataSetChanged()
                })
    }
}