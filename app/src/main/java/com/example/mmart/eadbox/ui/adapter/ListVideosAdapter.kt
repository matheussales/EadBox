package com.example.mmart.eadbox.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mmart.eadbox.R
import com.example.mmart.eadbox.model.Course
import kotlinx.android.synthetic.main.list_item.view.*

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
        val video = mVideos[position]

        holder.bindView(video)
    }

    class VideoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.video_title

        fun bindView(course: Course) {
            title.text = course.title
        }
    }
}