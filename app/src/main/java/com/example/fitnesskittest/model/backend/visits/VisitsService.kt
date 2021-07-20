package com.example.fitnesskittest.model.backend.visits

import com.example.fitnesskittest.model.dto.visit.VisitDto


interface VisitsService {
    fun getVisitsHistory(): List<VisitDto?>
}