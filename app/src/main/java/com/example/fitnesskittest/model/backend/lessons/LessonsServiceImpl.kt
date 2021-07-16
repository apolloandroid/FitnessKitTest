package com.example.fitnesskittest.model.backend.lessons

import com.example.fitnesskittest.model.backend.FitnessKitApi
import com.example.fitnesskittest.model.dto.lesson.LessonDto
import retrofit2.Retrofit
import javax.inject.Inject

class LessonsServiceImpl @Inject constructor(
    private val retrofit: Retrofit
) : LessonsService {
    private val api = retrofit.create(FitnessKitApi::class.java)

    override fun getLessonsHistory(): List<LessonDto> {
        return listOf()
    }
}