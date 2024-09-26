package com.example.infinitinews.domain.interactor

import com.example.infinitinews.data.repository.NewsRepository
import javax.inject.Inject

class HeadlinesUseCase @Inject constructor(private val repository: NewsRepository) {

    suspend operator fun invoke() =
        repository.getHeadLines()
    }