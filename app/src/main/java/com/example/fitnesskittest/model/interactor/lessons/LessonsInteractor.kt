package com.example.fitnesskittest.model.interactor.lessons

import com.example.fitnesskittest.model.entity.Lesson
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow


interface LessonsInteractor {
    fun getLessonsHistoryFromLocal(): Flow<List<Lesson>?>

    suspend fun updateLessonsHistory()
}