package com.example.fitnesskittest.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.fitnesskittest.model.database.lesson.LessonDao
import com.example.fitnesskittest.model.database.visit.VisitDao
import com.example.fitnesskittest.model.entity.Lesson
import com.example.fitnesskittest.model.entity.Visit


@Database(
    entities = [Lesson::class,
        Visit::class],
    version = 2
)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        const val DATABASE_NAME = "FitnessKit"
    }

    abstract fun lessonDao(): LessonDao
    abstract fun visitDao(): VisitDao
}