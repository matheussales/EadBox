package com.example.mmart.eadbox.ui.adapter

import android.content.Context
import android.graphics.BitmapFactory
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mmart.eadbox.R
import com.example.mmart.eadbox.model.Course
import kotlinx.android.synthetic.main.list_item.view.*
import java.net.URL
import java.util.*

class ListVideosAdapter(private val mContext: Context,
                        private val mVideos: List<Course>) : RecyclerView.Adapter<ListVideosAdapter.VideoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false)
        return VideoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mVideos.size
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        val course = mVideos[position]



        holder.bindView(course)
    }

    class VideoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.course_title
        val category = itemView.course_category
        val workload = itemView.course_workload
        val logoUrl = itemView.course_logo

        fun bindView(course: Course) {
            title.text = course.mTitle
            category.text = course.mCategory.mTitle
            
            val url = URL(course.mLogo)
            val bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream())

            logoUrl.setImageBitmap(bitmap)
        }
    }
}