package com.example.contactapp.presentation.naviagtion

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.contactapp.presentation.ContactViewModel
import com.example.contactapp.presentation.screen.AddEditScreen
import com.example.contactapp.presentation.screen.HomeScreen

@Composable
fun NavGraph(navHostController: NavHostController,viewModel: ContactViewModel) {
    val state by viewModel.state.collectAsState()
    NavHost(navController = navHostController, startDestination = Routes.Home.route){
        composable(Routes.AddEdit.route){
           AddEditScreen(
               navHostController = navHostController,
               state = viewModel.state.collectAsState().value,
               onEvent ={viewModel.saveContacts()}
           )
        }

        composable(Routes.Home.route){
            HomeScreen(
                navHostController = navHostController,
                state = state,
                viewModel=viewModel
            )
        }

    }
}