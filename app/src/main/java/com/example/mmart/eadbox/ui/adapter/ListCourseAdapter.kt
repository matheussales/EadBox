package com.example.mmart.eadbox.ui.adapter

import android.content.Context
import android.graphics.BitmapFactory
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mmart.eadbox.R
import com.example.mmart.eadbox.model.Course
import kotlinx.android.synthetic.main.course_item.view.*
import java.net.URL

class ListCourseAdapter(private val mContext: Context,
                        private val mVideos: List<Course>,
                        val clickListener: (Course) -> Unit) : RecyclerView.Adapter<ListCourseAdapter.VideoViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.course_item, parent, false)
        return VideoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mVideos.size
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        val course = mVideos[position]

        holder.bindView(course, clickListener)
    }

    class VideoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.course_title
        val category = itemView.course_category
        val workload = itemView.course_workload
        val logoUrl = itemView.course_logo

        fun bindView(course: Course, clickListener: (Course) -> Unit) {
            title.text = course.title
            category.text = course.category.title

            if (course.workload == null || course.workload.toInt() == 0) {
                workload.text = ""
            } else {
                val hour = course.workload.toInt()

                workload.text = "${hour.toString()}h"
            }

            val url = URL(course.logo)
            val bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream())

            logoUrl.setImageBitmap(bitmap)

            itemView.setOnClickListener { clickListener(course) }
        }
    }
}