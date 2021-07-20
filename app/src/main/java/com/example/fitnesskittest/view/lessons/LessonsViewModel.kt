package com.example.fitnesskittest.view.lessons

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitnesskittest.model.entity.Lesson
import com.example.fitnesskittest.model.interactor.lessons.LessonsInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LessonsViewModel @Inject constructor(
    private val lessonsInteractor: LessonsInteractor
) : ViewModel() {

    private val _lessons = MutableStateFlow<List<Lesson>>(listOf())
    val lessons = _lessons.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            lessonsInteractor.getLessonsHistory().collect { _lessons.value = it }
        }
    }
}