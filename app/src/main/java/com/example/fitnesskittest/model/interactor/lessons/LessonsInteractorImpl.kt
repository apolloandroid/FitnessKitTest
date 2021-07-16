package com.example.fitnesskittest.model.interactor.lessons

import com.example.fitnesskittest.model.backend.lessons.LessonsService
import com.example.fitnesskittest.model.entity.Lesson
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LessonsInteractorImpl @Inject constructor(
    service: LessonsService
) : LessonsInteractor {
    override fun getLessonsHistory(): Flow<List<Lesson>> {
        return flow { listOf<Lesson>() }
    }
}