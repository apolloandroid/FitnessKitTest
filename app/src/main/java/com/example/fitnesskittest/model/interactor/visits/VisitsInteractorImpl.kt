package com.example.fitnesskittest.model.interactor.visits

import com.example.fitnesskittest.model.backend.visits.VisitsService
import com.example.fitnesskittest.model.entity.Visit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class VisitsInteractorImpl @Inject constructor(
    service: VisitsService
) : VisitsInteractor {
    override fun getVisitsHistory(): Flow<List<Visit>> {
        return flow { listOf<Visit>() }
    }
}