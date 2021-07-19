package com.example.fitnesskittest.model.mapper.lessons

import com.example.fitnesskittest.model.dto.lesson.LessonDto
import com.example.fitnesskittest.model.entity.Lesson
import com.example.fitnesskittest.model.entity.LessonType
import javax.inject.Inject

class LessonMapperImpl @Inject constructor() : LessonMapper {
    override fun getLessonFromDto(lessonDto: LessonDto?): Lesson {
        return Lesson(
            name = lessonDto?.name.orEmpty(),
            trainerName = lessonDto?.trainerName.orEmpty(),
            type = LessonType.create(lessonDto?.type.orEmpty()),
            price = lessonDto?.price ?: Lesson.FREE_PRICE,
            date = lessonDto?.date.orEmpty()
        )
    }
}