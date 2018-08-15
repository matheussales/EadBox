package com.example.mmart.eadbox.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mmart.eadbox.R
import com.example.mmart.eadbox.model.Course
import kotlinx.android.synthetic.main.course_item.view.*

class ListCourseAdapter(private val mContext: Context,
                        private val mVideos: List<Course>,
                        private val clickListener: (Course) -> Unit) : RecyclerView.Adapter<ListCourseAdapter.CourseViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.course_item, parent, false)
        return CourseViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mVideos.size
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val course = mVideos[position]

        holder.bindView(course, clickListener)
    }

    class CourseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val title = itemView.course_title!!
        private val category = itemView.course_category!!
        private val workload = itemView.course_workload!!
        private val logoUrl = itemView.course_logo!!

        fun bindView(course: Course, clickListener: (Course) -> Unit) {
            title.text = course.title
            category.text = course.category.title

            if (course.workloadIsNull() || course.workloadIsZero()) {
                workload.text = ""
            } else {
                val hour = course.workload!!.toInt()
                workload.text = "${hour.toString()}h"
            }

            val bitmap = course.convertToBitmap()

            logoUrl.setImageBitmap(bitmap)
            itemView.setOnClickListener { clickListener(course) }
        }
    }
}