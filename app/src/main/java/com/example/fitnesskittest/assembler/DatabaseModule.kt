package com.example.fitnesskittest.assembler

import android.content.Context
import androidx.room.Room
import com.example.fitnesskittest.model.database.AppDatabase
import com.example.fitnesskittest.model.database.lesson.LessonDao
import com.example.fitnesskittest.model.database.visit.VisitDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            AppDatabase.DATABASE_NAME
        ).fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideLessonsDao(database: AppDatabase): LessonDao = database.lessonDao()

    @Provides
    fun provideVisitDao(database: AppDatabase): VisitDao = database.visitDao()
}