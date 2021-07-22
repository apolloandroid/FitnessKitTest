package com.example.fitnesskittest.model.mapper.visits

import com.example.fitnesskittest.model.dto.visit.VisitDto
import com.example.fitnesskittest.model.entity.Visit
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class VisitMapperImpl @Inject constructor(): VisitMapper {
    override fun getVisitFromDto(visitDto: VisitDto?): Visit {
        return Visit(
            id = UUID.randomUUID().toString(),
            name = visitDto?.name.orEmpty(),
            date = visitDto?.date.orEmpty()
        )
    }
}