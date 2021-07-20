package com.example.fitnesskittest.model.interactor.visits

import com.example.fitnesskittest.model.backend.visits.VisitsService
import com.example.fitnesskittest.model.entity.Visit
import com.example.fitnesskittest.model.mapper.visits.VisitMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject


class VisitsInteractorImpl @Inject constructor(
    private val service: VisitsService,
    private val mapper: VisitMapper
) : VisitsInteractor {
    override fun getVisitsHistory(): Flow<List<Visit>> {
        val visits = service.getVisitsHistory().map { mapper.getVisitFromDto(it) }
        return MutableStateFlow(visits)
    }
}