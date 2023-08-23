package com.ad_coding.apollographqlcourse

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ad_coding.apollographqlcourse.ui.screen.character_detail.CharacterScreen
import com.ad_coding.apollographqlcourse.ui.screen.character_list.CharacterListScreen
import com.ad_coding.apollographqlcourse.ui.theme.ApolloGraphQLCourseTheme
import com.ad_coding.apollographqlcourse.ui.util.Route
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ApolloGraphQLCourseTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = Route.characterList
                )
                {
                    composable(Route.characterList) {
                        CharacterListScreen(
                            onCharacterClick = { id ->
                                navController.navigate(
                                    Route.character
                                        .replace("{id}", id)
                                )
                            })
                    }
                    composable(Route.character)
                    {
                        CharacterScreen(navigateBack = {
                            navController.popBackStack()
                        })
                    }
                }
            }
        }
    }
}