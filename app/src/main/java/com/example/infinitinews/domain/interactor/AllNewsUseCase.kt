package com.example.infinitinews.domain.interactor

import com.example.infinitinews.data.repository.NewsRepository
import javax.inject.Inject

class AllNewsUseCase @Inject constructor(private val repository: NewsRepository) {

    suspend operator fun invoke() =
        repository.getAllNews()
    }