package com.example.mmart.eadbox.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Course (val title: String,
                   val category: Category,
                   val workload: Double?,
                   @SerializedName("logo_url") val logo: String,
                   val lectures: List<Lecture>) : Serializable

data class Category(
        @SerializedName("title")
        val title: String) : Serializable

data class Lecture(val title: String) : Serializable