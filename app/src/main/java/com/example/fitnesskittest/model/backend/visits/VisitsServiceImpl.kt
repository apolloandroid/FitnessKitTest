package com.example.fitnesskittest.model.backend.visits

import com.example.fitnesskittest.model.backend.FitnessKitApi
import com.example.fitnesskittest.model.dto.visit.VisitDto
import retrofit2.Retrofit
import javax.inject.Inject

class VisitsServiceImpl @Inject constructor(
    private val retrofit: Retrofit
) : VisitsService {
    private val api = retrofit.create(FitnessKitApi::class.java)

    override fun getVisitsHistory(): List<VisitDto> {
        return listOf()
    }
}