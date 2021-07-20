package com.example.fitnesskittest.model.mapper.visits

import com.example.fitnesskittest.model.dto.visit.VisitDto
import com.example.fitnesskittest.model.entity.Visit


interface VisitMapper {
    fun getVisitFromDto(visitDto: VisitDto?): Visit
}