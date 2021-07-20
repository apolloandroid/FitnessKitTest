package com.example.fitnesskittest.view.visits

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitnesskittest.model.entity.Visit
import com.example.fitnesskittest.model.interactor.visits.VisitsInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class VisitsViewModel @Inject constructor(
    private val visitsInteractor: VisitsInteractor
) : ViewModel() {

    private val _visits = MutableStateFlow<List<Visit>>(listOf())
    val visits = _visits.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            visitsInteractor.getVisitsHistory().collect { _visits.value = it }
        }
    }
}