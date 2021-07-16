package com.example.fitnesskittest.model.backend

import com.example.fitnesskittest.model.dto.lesson.LessonResponse
import com.example.fitnesskittest.model.dto.visit.VisitResponse
import retrofit2.Call
import retrofit2.http.GET

interface FitnessKitApi {
    companion object {
        val baseUrl = "https://sample.fitnesskit-admin.ru/accounts/"
    }

    @GET("get_client_lesson_history/")
    fun getLessonsHistory( ): Call<LessonResponse>

    @GET("get_client_visit_history/")
    fun getVisitsHistory(): Call<VisitResponse>
}