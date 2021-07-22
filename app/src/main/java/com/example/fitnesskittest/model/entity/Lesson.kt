package com.example.fitnesskittest.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "lessons")
data class Lesson(
    @PrimaryKey
    val id: String,
    val name: String,
    val trainerName: String,
    val type: String,
    val price: Int,
    val date: String
) {
    companion object {
        val FREE_PRICE = 0
        val TYPE_GROUP = "Group"
    }
}
