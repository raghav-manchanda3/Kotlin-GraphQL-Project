@file:OptIn(ExperimentalMaterial3Api::class)

package com.ad_coding.apollographqlcourse.ui.screen.character_list

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import coil.request.ImageRequest

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterListScreen(
    viewModel: CharacterListViewModel = hiltViewModel(),
    onCharacterClick: (String) -> Unit
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Character App")
                }
            )
        }

    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Gray)
                .padding(top = 60.dp)
        )
        {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            )
            {
                items(state.characterList.size) { index ->
                    val character = state.characterList[index]
                    Card(
                        shape = RoundedCornerShape(10.dp), elevation = CardDefaults.cardElevation(
                            defaultElevation = 10.dp,

                            )
                    )
                    {
                        Column(modifier = Modifier.clickable { onCharacterClick(character.id) }) {
                            AsyncImage(
                                model = ImageRequest.Builder(context)
                                    .data(character.image)
                                    .crossfade(true)
                                    .build(), contentDescription = null,
                                modifier = Modifier.size(200.dp)
                            )
                            Text(
                                text = " ${character.name}",
                                fontWeight = FontWeight.Bold
                            )
                            Text(text = character.species)
                        }
                    }
                }
            }
        }
    }
}

