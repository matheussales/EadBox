package com.example.mmart.eadbox.ui.adapter

import com.example.mmart.eadbox.model.Course

interface OnItemClickListener {
    fun onItemClick(courses: List<Course>)
}