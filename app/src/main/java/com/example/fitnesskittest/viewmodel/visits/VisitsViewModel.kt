package com.example.fitnesskittest.viewmodel.visits

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitnesskittest.model.entity.Visit
import com.example.fitnesskittest.model.interactor.visits.VisitsInteractor
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
class VisitsViewModel @Inject constructor(
    private val visitsInteractor: VisitsInteractor
) : ViewModel() {

    private val _visitsHistory = MutableStateFlow<List<Visit>>(listOf())
    val visits = _visitsHistory.asStateFlow()

    val hideLoader = SingleLiveEvent()

    init {
        getLessonsHistory()
    }

    fun onRefreshVisits() = updateVisitsHistory()

    private fun getLessonsHistory() {
        viewModelScope.launch(Dispatchers.IO) {
            visitsInteractor.getVisitsHistoryFromLocal().collect { visits ->
                if (visits.isNullOrEmpty()) updateVisitsHistory()
                else _visitsHistory.value = visits
            }
            withContext(Dispatchers.Main) { hideLoader }
        }
    }

    private fun updateVisitsHistory() {
        viewModelScope.launch(Dispatchers.IO) {
            visitsInteractor.updateVisitsHistory()
            withContext(Dispatchers.Main) { hideLoader.call() }
        }
    }
}