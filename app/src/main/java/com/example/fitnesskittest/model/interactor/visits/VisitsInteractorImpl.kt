package com.example.fitnesskittest.model.interactor.visits

import com.example.fitnesskittest.model.backend.visits.VisitsService
import com.example.fitnesskittest.model.database.visit.VisitDao
import com.example.fitnesskittest.model.entity.Visit
import com.example.fitnesskittest.model.mapper.visits.VisitMapper
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class VisitsInteractorImpl @Inject constructor(
    private val remoteDataSource: VisitsService,
    private val localDataSource: VisitDao,
    private val mapper: VisitMapper
) : VisitsInteractor {

    override suspend fun updateVisitsHistory() {
        val visits = remoteDataSource.getVisitsHistory().map { mapper.getVisitFromDto(it) }
        localDataSource.update(visits)
    }

    override fun getVisitsHistoryFromLocal(): Flow<List<Visit>> = localDataSource.getVisitsFlow()
}