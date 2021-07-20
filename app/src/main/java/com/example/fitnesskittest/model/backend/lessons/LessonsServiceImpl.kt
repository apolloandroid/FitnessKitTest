package com.example.fitnesskittest.model.backend.lessons

import com.example.fitnesskittest.model.backend.FitnessKitApi
import com.example.fitnesskittest.model.dto.lesson.LessonDto
import retrofit2.Retrofit
import java.lang.Exception
import javax.inject.Inject


class LessonsServiceImpl @Inject constructor(retrofit: Retrofit) : LessonsService {
    private val api = retrofit.create(FitnessKitApi::class.java)

    override fun getLessonsHistory(): List<LessonDto?> {
        return try {
            val response = api.getLessonsHistory().execute()
            response.body()?.lessons ?: listOf()
        } catch (e: Exception) {
            listOf()
        }
    }
}