package com.example.fitnesskittest.model.dto.visit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class VisitDto(
    @SerializedName("name")
    @Expose
    val name: String?,
    @SerializedName("date")
    @Expose
    val date: String?
) : Serializable
