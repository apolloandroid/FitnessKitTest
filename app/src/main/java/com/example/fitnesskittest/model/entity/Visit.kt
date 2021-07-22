package com.example.fitnesskittest.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "visits")
data class Visit(
    @PrimaryKey
    val id: String,
    val name: String,
    val date: String
)