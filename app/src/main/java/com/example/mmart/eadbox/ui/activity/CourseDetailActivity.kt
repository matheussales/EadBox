package com.example.mmart.eadbox.ui.activity

import android.graphics.BitmapFactory
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.mmart.eadbox.R
import com.example.mmart.eadbox.model.Course
import com.example.mmart.eadbox.model.Lecture
import com.example.mmart.eadbox.ui.adapter.ListLectureAdapter
import kotlinx.android.synthetic.main.activity_course_detail.*
import java.net.URL

class CourseDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_detail)

        val course: Course = findCourse()

        configureTitle(course)
        setImageBanner(course)
        val lectures = findLectures(course)

        configureAdapter(lectures)
    }

    private fun findLectures(course: Course): List<Lecture> {
        return course.lectures
    }

    private fun configureAdapter(lectures: List<Lecture>) {
        lecture_recycler_view.adapter = ListLectureAdapter(this, lectures)
        lecture_recycler_view.layoutManager = LinearLayoutManager(this)
    }

    private fun setImageBanner(course: Course) {
        val url = URL(course.logo)
        val bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream())
        course_logo.setImageBitmap(bitmap)
    }

    private fun findCourse(): Course {
        return intent.getSerializableExtra("course") as Course
    }

    private fun configureTitle(course: Course) {
        title = course.title
    }
}