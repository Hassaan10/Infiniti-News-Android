package com.example.infinitinews.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.infinitinews.data.model.Article
import com.example.infinitinews.ui.screens.DetailsScreen
import com.example.infinitinews.ui.screens.MainScreen
import com.example.infinitinews.ui.viewmodels.MainViewModel
import kotlinx.serialization.Serializable
import kotlin.reflect.typeOf

// Define a home destination that doesn't take any arguments
@Serializable
object Main

// Define a profile destination that takes an ID
@Serializable
data class Detail(val article: Article)

@Composable
fun MainNavigation() {

    val navController = rememberNavController()


    NavHost(navController = navController, startDestination = Main ) {

        composable<Main> {
            val viewModel = hiltViewModel<MainViewModel>()
            MainScreen(viewModel, onItemClick = { navController.navigate(Detail(it)) })
        }

        composable<Detail>(typeMap = mapOf(typeOf<Article>() to ArticleNavType)) { backStackEntry ->
            val parameters = backStackEntry.toRoute<Detail>()
            DetailsScreen(parameters.article, navigateToBack = { navController.navigateUp() })
        }

    }

}