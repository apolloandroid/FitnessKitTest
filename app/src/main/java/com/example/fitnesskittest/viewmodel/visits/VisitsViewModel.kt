package com.example.fitnesskittest.viewmodel.visits

import androidx.lifecycle.ViewModel
import com.example.fitnesskittest.model.interactor.visits.VisitsInteractorImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class VisitsViewModel @Inject constructor(
    private val visitsInteractor: VisitsInteractorImpl
) : ViewModel() {
}