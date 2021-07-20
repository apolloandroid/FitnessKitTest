package com.example.fitnesskittest.model.mapper.visits

import com.example.fitnesskittest.model.dto.visit.VisitDto
import com.example.fitnesskittest.model.entity.Visit
import javax.inject.Inject


class VisitMapperImpl @Inject constructor(): VisitMapper {
    override fun getVisitFromDto(visitDto: VisitDto?): Visit {
        return Visit(
            name = visitDto?.name.orEmpty(),
            date = visitDto?.date.orEmpty()
        )
    }
}