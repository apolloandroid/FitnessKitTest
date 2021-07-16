package com.example.fitnesskittest.model.interactor.visits

import com.example.fitnesskittest.model.entity.Visit
import kotlinx.coroutines.flow.Flow


interface VisitsInteractor {
    fun getVisitsHistory(): Flow<List<Visit>>
}