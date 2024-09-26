package com.example.infinitinews.ui.events

sealed class UIEvent {
    data object FetchAllNews: UIEvent()
    data object FetchHeadlines: UIEvent()
    data object FetchEverything: UIEvent()
}