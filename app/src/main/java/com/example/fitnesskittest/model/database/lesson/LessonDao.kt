package com.example.fitnesskittest.model.database.lesson

import androidx.room.*
import com.example.fitnesskittest.model.entity.Lesson
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow


@Dao
interface LessonDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(lessons: List<Lesson>)

    @Query("SELECT * FROM lessons ")
    fun getLessonsFlow(): Flow<List<Lesson>>

    @Query("DELETE FROM lessons")
    suspend fun clear()

    @Transaction
    suspend fun update(lessons: List<Lesson>){
        clear()
        insert(lessons)
    }
}