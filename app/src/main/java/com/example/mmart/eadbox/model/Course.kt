package com.example.mmart.eadbox.model

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.net.URL

data class Course(val title: String,
                  val category: Category,
                  val workload: Double?,
                  @SerializedName("logo_url") val logo: String,
                  val lectures: List<Lecture>) : Serializable {


    fun convertToBitmap(): Bitmap? {
        val url = URL(this.logo)
        return BitmapFactory.decodeStream(url.openConnection().getInputStream())
    }

    fun workloadIsNull() = this.workload == null

    fun workloadIsZero() = this.workload!!.toInt() == 0

}

data class Category(val title: String) : Serializable

data class Lecture(val title: String) : Serializable
