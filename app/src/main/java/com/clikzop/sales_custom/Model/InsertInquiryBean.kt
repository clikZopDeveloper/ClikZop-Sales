package com.clikzop.sales_custom.Model


import com.google.gson.annotations.SerializedName

data class InsertInquiryBean(
    @SerializedName("data")
    val `data`: List<Any>,
    @SerializedName("error")
    val error: Boolean, // false
    @SerializedName("msg")
    val msg: String // Save Successfully
)