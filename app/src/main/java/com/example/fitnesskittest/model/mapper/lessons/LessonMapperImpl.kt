package com.example.fitnesskittest.model.mapper.lessons

import com.example.fitnesskittest.model.dto.lesson.LessonDto
import com.example.fitnesskittest.model.entity.Lesson
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class LessonMapperImpl @Inject constructor() : LessonMapper {
    override fun getLessonFromDto(lessonDto: LessonDto?): Lesson {
        return Lesson(
            id = UUID.randomUUID().toString(),
            name = lessonDto?.name.orEmpty(),
            trainerName = lessonDto?.trainerName.orEmpty(),
            type = lessonDto?.type.orEmpty(),
            price = lessonDto?.price ?: Lesson.FREE_PRICE,
            date = lessonDto?.date.orEmpty()
        )
    }
}