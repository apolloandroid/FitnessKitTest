package com.example.fitnesskittest.model.dto.visit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class VisitResponse(
    @SerializedName("visits_history")
    @Expose
    val visits: List<VisitDto>?
)
