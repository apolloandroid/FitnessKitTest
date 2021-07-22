package com.example.fitnesskittest.model.interactor.lessons

import com.example.fitnesskittest.model.backend.lessons.LessonsService
import com.example.fitnesskittest.model.database.lesson.LessonDao
import com.example.fitnesskittest.model.entity.Lesson
import com.example.fitnesskittest.model.mapper.lessons.LessonMapper
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class LessonsInteractorImpl @Inject constructor(
    private val remoteDataSource: LessonsService,
    private val localDataSource: LessonDao,
    private val mapper: LessonMapper
) : LessonsInteractor {

    override suspend fun updateLessonsHistory() {
        val lessons = remoteDataSource.getLessonsHistory().map { mapper.getLessonFromDto(it) }
        localDataSource.update(lessons)
    }

    override fun getLessonsHistoryFromLocal(): Flow<List<Lesson>> = localDataSource.getLessonsFlow()
}
