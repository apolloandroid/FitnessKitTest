package com.example.fitnesskittest.model.backend

import com.example.fitnesskittest.model.dto.lesson.LessonResponse
import com.example.fitnesskittest.model.dto.visit.VisitResponse
import retrofit2.Call
import retrofit2.http.GET

interface FitnessKitApi {
    companion object {
        const val baseUrl = "https://sample.fitnesskit-admin.ru/accounts/"
        const val getLessonsHistory = "get_client_lesson_history/"
        const val getVisitsHistory = "get_client_visit_history/"
    }

    @GET(getLessonsHistory)
    fun getLessonsHistory(): Call<LessonResponse>

    @GET(getVisitsHistory)
    fun getVisitsHistory(): Call<VisitResponse>
}