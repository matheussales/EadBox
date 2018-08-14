package com.example.mmart.eadbox.model

import com.google.gson.annotations.SerializedName

data class Course(@SerializedName("title")
                  val mTitle: String,
                  @SerializedName("category")
    val mCategory: Category)
