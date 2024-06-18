package com.udenyijoshua.foodbankcompose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.udenyijoshua.foodbankcompose.screens.DonationUI
import com.udenyijoshua.foodbankcompose.screens.HomeUI
import com.udenyijoshua.foodbankcompose.screens.PaymentUI
import com.udenyijoshua.foodbankcompose.screens.ProfileUI

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier : Modifier = Modifier
){

    NavHost(
        navController = navController,
        startDestination = BottomBar.HomeUI.route
    ){
        composable(route = BottomBar.HomeUI.route)
        {
            HomeUI()
        }
        composable(route = BottomBar.DonationUI.route)
        {
            DonationUI()
        }
        composable(route = BottomBar.PaymentUI.route)
        {
            PaymentUI()
        }
        composable(route = BottomBar.ProfileUI.route)
        {
            ProfileUI()
        }
    }

}