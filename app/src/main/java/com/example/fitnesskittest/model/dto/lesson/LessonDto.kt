package com.example.fitnesskittest.model.dto.lesson

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class LessonDto(
    @SerializedName("name")
    @Expose
    val name: String?,
    @SerializedName("trainer_name")
    @Expose
    val trainerName: String?,
    @SerializedName("type")
    @Expose
    val type: String?,
    @SerializedName("price")
    @Expose
    val price: Int?,
    @SerializedName("date")
    @Expose
    val date: String?
) : Serializable
