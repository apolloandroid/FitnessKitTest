package com.example.fitnesskittest.model.interactor.lessons

import com.example.fitnesskittest.model.backend.lessons.LessonsService
import com.example.fitnesskittest.model.entity.Lesson
import com.example.fitnesskittest.model.mapper.lessons.LessonMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject


class LessonsInteractorImpl @Inject constructor(
    private val service: LessonsService,
    private val mapper: LessonMapper
) : LessonsInteractor {
    override fun getLessonsHistory(): Flow<List<Lesson>> {
        val lessons = service.getLessonsHistory().map { mapper.getLessonFromDto(it) }
        return MutableStateFlow(lessons)
    }
}