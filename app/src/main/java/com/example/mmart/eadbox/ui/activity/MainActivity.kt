package com.example.mmart.eadbox.ui.activity

import android.content.Intent
import android.os.Bundle
import android.os.StrictMode
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.mmart.eadbox.R
import com.example.mmart.eadbox.model.Course
import com.example.mmart.eadbox.model.api.EadBoxApi
import com.example.mmart.eadbox.ui.adapter.ListCourseAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var courses = mutableListOf<Course>()
    private val adapter = ListCourseAdapter(this, courses) { course: Course ->  onItemClick(course)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        val recyclerView = recycler_view
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)


        val api = EadBoxApi()
        api.loadCourses()!!
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    course -> courses.add(Course(course.title, course.category, course.workload, course.logo, course.lectures))
                }, {
                    e -> e.printStackTrace()
                }, {
                    adapter.notifyDataSetChanged()
                })
    }

    private fun onItemClick(course: Course) {
        val intent = Intent(this, CourseDetailActivity::class.java)
        intent.putExtra("course", course)
        startActivity(intent)
    }
}