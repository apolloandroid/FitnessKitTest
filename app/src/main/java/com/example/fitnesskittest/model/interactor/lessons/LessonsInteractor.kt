package com.example.fitnesskittest.model.interactor.lessons

import com.example.fitnesskittest.model.entity.Lesson
import kotlinx.coroutines.flow.Flow

interface LessonsInteractor {
    suspend fun getLessonsHistory(): Flow<List<Lesson>>
}