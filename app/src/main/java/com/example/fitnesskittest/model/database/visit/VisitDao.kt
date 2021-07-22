package com.example.fitnesskittest.model.database.visit

import androidx.room.*
import com.example.fitnesskittest.model.entity.Lesson
import com.example.fitnesskittest.model.entity.Visit
import kotlinx.coroutines.flow.Flow


@Dao
interface VisitDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(visits: List<Visit>)

    @Query("SELECT * FROM visits ")
    fun getVisitsFlow(): Flow<List<Visit>>

    @Query("DELETE FROM visits")
    suspend fun clear()

    @Transaction
    suspend fun update(visits: List<Visit>){
        clear()
        insert(visits)
    }
}