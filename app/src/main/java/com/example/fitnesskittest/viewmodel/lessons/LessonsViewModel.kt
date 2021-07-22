package com.example.fitnesskittest.viewmodel.lessons

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitnesskittest.model.entity.Lesson
import com.example.fitnesskittest.model.interactor.lessons.LessonsInteractor
import com.example.fitnesskittest.util.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class LessonsViewModel @Inject constructor(
    private val lessonsInteractor: LessonsInteractor
) : ViewModel() {

    private var _lessonsHistory = MutableStateFlow<List<Lesson>>(emptyList())
    val lessonsHistory = _lessonsHistory.asStateFlow()

    val hideLoader = SingleLiveEvent()

    init {
        getLessonsHistory()
    }

    fun onRefreshLessons() = updateLessonsHistory()

    private fun getLessonsHistory() {
        viewModelScope.launch(Dispatchers.IO) {
            lessonsInteractor.getLessonsHistoryFromLocal().collect { lessons ->
                if (lessons.isNullOrEmpty()) updateLessonsHistory()
                else _lessonsHistory.value = lessons
            }
        }
    }

    private fun updateLessonsHistory() {
        viewModelScope.launch(Dispatchers.IO) {
            lessonsInteractor.updateLessonsHistory()
            withContext(Dispatchers.Main) { hideLoader.call() }
        }
    }
}