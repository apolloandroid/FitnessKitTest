package com.example.fitnesskittest.model.dto.lesson

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LessonResponse(
    @SerializedName("lessons_history")
    @Expose
    val lessons: List<LessonDto>?
)
