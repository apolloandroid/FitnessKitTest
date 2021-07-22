package com.example.fitnesskittest.assembler

import com.example.fitnesskittest.model.backend.lessons.LessonsServiceImpl
import com.example.fitnesskittest.model.backend.visits.VisitsServiceImpl
import com.example.fitnesskittest.model.database.lesson.LessonDao
import com.example.fitnesskittest.model.database.visit.VisitDao
import com.example.fitnesskittest.model.interactor.lessons.*
import com.example.fitnesskittest.model.interactor.visits.*
import com.example.fitnesskittest.model.mapper.lessons.LessonMapper
import com.example.fitnesskittest.model.mapper.lessons.LessonMapperImpl
import com.example.fitnesskittest.model.mapper.visits.VisitMapper
import com.example.fitnesskittest.model.mapper.visits.VisitMapperImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class InteractorModule {

    @Provides
    fun provideLessonsInteractor(
        lessonsService: LessonsServiceImpl,
        lessonDao: LessonDao,
        lessonMapper: LessonMapperImpl
    ): LessonsInteractor = LessonsInteractorImpl(lessonsService, lessonDao, lessonMapper)

    @Provides
    fun provideVisitsInteractor(
        visitsService: VisitsServiceImpl,
        visitDao: VisitDao,
        visitMapper: VisitMapperImpl
    ): VisitsInteractor = VisitsInteractorImpl(visitsService, visitDao, visitMapper)

    @Provides
    fun provideLessonMapper(): LessonMapper = LessonMapperImpl()

    @Provides
    fun provideVisitMapper(): VisitMapper = VisitMapperImpl()
}