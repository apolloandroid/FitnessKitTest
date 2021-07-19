package com.example.fitnesskittest.assembler

import com.example.fitnesskittest.model.backend.lessons.LessonsServiceImpl
import com.example.fitnesskittest.model.backend.visits.VisitsServiceImpl
import com.example.fitnesskittest.model.interactor.lessons.*
import com.example.fitnesskittest.model.interactor.visits.*
import com.example.fitnesskittest.model.mapper.lessons.LessonMapperImpl
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
        lessonMapper: LessonMapperImpl
    ): LessonsInteractor {
        return LessonsInteractorImpl(lessonsService, lessonMapper)
    }

    @Provides
    fun provideVisitsInteractor(visitsServiceImpl: VisitsServiceImpl): VisitsInteractor {
        return VisitsInteractorImpl(visitsServiceImpl)
    }
}