package com.example.fitnesskittest.model.backend.visits

import android.util.Log
import com.example.fitnesskittest.model.backend.FitnessKitApi
import com.example.fitnesskittest.model.dto.visit.VisitDto
import retrofit2.Retrofit
import javax.inject.Inject


class VisitsServiceImpl @Inject constructor(retrofit: Retrofit) : VisitsService {
    private val api = retrofit.create(FitnessKitApi::class.java)

    override fun getVisitsHistory(): List<VisitDto> {
        val response = api.getVisitsHistory().execute()
        Log.d("TAG", response.body()?.visits.toString())
        return response.body()?.visits ?: listOf()
    }
}