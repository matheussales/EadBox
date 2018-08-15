package com.example.mmart.eadbox.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mmart.eadbox.R
import com.example.mmart.eadbox.model.Lecture
import kotlinx.android.synthetic.main.lecture_item.view.*


class ListLectureAdapter(private val mContext: Context,
                        private val mVideos: List<Lecture>) : RecyclerView.Adapter<ListLectureAdapter.LectureViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LectureViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.lecture_item, parent, false)
        return LectureViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mVideos.size
    }

    override fun onBindViewHolder(holder: LectureViewHolder, position: Int) {
        val course = mVideos[position]
        holder.bindView(course)
    }

    class LectureViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val title = itemView.lecture_title!!

        fun bindView(lecture: Lecture) {
            title.text = lecture.title
        }
    }
}