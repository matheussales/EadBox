package com.example.mmart.eadbox.model

import com.google.gson.annotations.SerializedName

data class Course(@SerializedName("title") val mTitle: String,
                  @SerializedName("category") val mCategory: Category,
                  @SerializedName("workload") val mWorkload: Double?,
                  @SerializedName("logo_url") val mLogo: String)

data class Category(
        @SerializedName("title")
        val mTitle: String
)