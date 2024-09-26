package com.example.infinitinews.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.pulltorefresh.pullToRefresh
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.infinitinews.data.model.Article
import com.example.infinitinews.ui.components.AllNewsSection
import com.example.infinitinews.ui.components.BreakingNewsSection
import com.example.infinitinews.ui.events.UIEvent
import com.example.infinitinews.ui.viewmodels.MainViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(viewModel: MainViewModel, onItemClick: (Article) -> Unit) {
    val snackbarState = remember { SnackbarHostState() }
    val pullRefreshState = rememberPullToRefreshState()
    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
        TopAppBar(title = {
        Column {
            Text(text = "Hello")
            Text(text = "Explore the news around the world ")
        }
    })
    }) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            SnackbarHost(hostState = snackbarState)
            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.pullToRefresh(
                state = pullRefreshState,
                isRefreshing = false,
                onRefresh = { viewModel.sendUIEvents(UIEvent.FetchEverything) }
            )) {
                BreakingNewsSection(viewModel, snackbarState, onItemClick = onItemClick)
                Spacer(Modifier.height(20.dp))
                AllNewsSection(viewModel, snackbarState, onItemClick = onItemClick)
            }
        }

    }

}