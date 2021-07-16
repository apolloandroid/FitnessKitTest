package com.example.fitnesskittest.viewmodel.lessons

import androidx.lifecycle.ViewModel
import com.example.fitnesskittest.model.interactor.lessons.LessonsInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LessonsViewModel @Inject constructor(
    private val lessonsInteractor: LessonsInteractor
) : ViewModel() {
}