package com.example.infinitinews.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.infinitinews.data.network.ApiResponse
import com.example.infinitinews.domain.interactor.AllNewsUseCase
import com.example.infinitinews.domain.interactor.HeadlinesUseCase
import com.example.infinitinews.ui.events.UIEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val allNewsUseCase: AllNewsUseCase,
                                        private val headlineUseCase: HeadlinesUseCase ): ViewModel() {

    private val _allNewsState = MutableStateFlow<ApiResponse>(ApiResponse.Loading)
    val allNewsState = _allNewsState.asStateFlow()

    private val _headlinesState = MutableStateFlow<ApiResponse>(ApiResponse.Loading)
    val headlinesState = _headlinesState.asStateFlow()

    init {
        fetchHeadLines()
        fetchAllNews()
    }

    private fun fetchAllNews() {
        viewModelScope.launch {
            allNewsUseCase.invoke().collect {
                _allNewsState.value = it
            }
        }
    }

    private fun fetchHeadLines() {
        viewModelScope.launch {
            headlineUseCase.invoke().collect {
                _headlinesState.value = it
            }
        }
    }

    fun sendUIEvents(uiEvent: UIEvent) {
        when(uiEvent) {
            UIEvent.FetchAllNews -> fetchAllNews()
            UIEvent.FetchEverything -> {
                fetchHeadLines()
                fetchAllNews()
            }
            UIEvent.FetchHeadlines -> fetchHeadLines()
        }
    }
}