package com.example.fitnesskittest.model.backend.lessons

import com.example.fitnesskittest.model.dto.lesson.LessonDto


interface LessonsService {
    fun getLessonsHistory(): List<LessonDto?>
}