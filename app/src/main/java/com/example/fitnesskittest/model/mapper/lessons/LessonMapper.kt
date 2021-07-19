package com.example.fitnesskittest.model.mapper.lessons

import com.example.fitnesskittest.model.dto.lesson.LessonDto
import com.example.fitnesskittest.model.entity.Lesson

interface LessonMapper {
    fun getLessonFromDto(lessonDto: LessonDto): Lesson
}