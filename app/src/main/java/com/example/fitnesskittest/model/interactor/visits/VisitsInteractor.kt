package com.example.fitnesskittest.model.interactor.visits

import com.example.fitnesskittest.model.entity.Visit
import kotlinx.coroutines.flow.Flow


interface VisitsInteractor {

    fun getVisitsHistoryFromLocal(): Flow<List<Visit>?>

    suspend fun updateVisitsHistory()
}