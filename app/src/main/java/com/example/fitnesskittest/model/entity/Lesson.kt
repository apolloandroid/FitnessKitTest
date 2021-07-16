package com.example.fitnesskittest.model.entity

import com.example.fitnesskittest.R

data class Lesson(
    val name: String?,
    val trainerName: String,
    val type: LessonType,
    val price: Int?,
    val date: String
)

sealed class LessonType(private val imageResourceId: Int) {
    companion object {
        private val TYPE_GROUP = "Group"
        fun create(lessonType: String): LessonType = when (lessonType) {
            TYPE_GROUP -> Group()
            else -> Personal()
        }
    }

    class Group : LessonType(R.drawable.ic_lesson_group)

    class Personal : LessonType(R.drawable.ic_lesson_personal)
}
