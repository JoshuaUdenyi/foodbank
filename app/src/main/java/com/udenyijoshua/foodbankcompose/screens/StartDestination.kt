package com.udenyijoshua.foodbankcompose.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.udenyijoshua.foodbankcompose.navigation.AppNavHost
import com.udenyijoshua.foodbankcompose.navigation.BottomBar
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun  StartDestination(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Foodbank.", color = Color.White, fontWeight = FontWeight.Medium)
                },
                actions = {
                    Icon(
                        imageVector = Icons.Rounded.Notifications,
                        contentDescription = "notification",
                        tint = Color.White,
                        modifier = modifier.padding(end = 10.dp)
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(
                        0,
                        150,
                        106
                    )
                )
            )
        },
        bottomBar = { BottomNavBar(navController = navController) }
    ) {innerPadding ->
        val customPaddingValues = PaddingValues(
            start = innerPadding.calculateStartPadding(LayoutDirection.Ltr) + 16.dp,
            top = innerPadding.calculateTopPadding() + 16.dp, // Custom padding added here
            end = innerPadding.calculateEndPadding(LayoutDirection.Ltr) + 16.dp,
            bottom = innerPadding.calculateBottomPadding()
        )

        Column(modifier = Modifier
            .fillMaxSize()
            .padding(customPaddingValues)) {
            AppNavHost(navController = navController)
        }
    }
}

@Composable
fun BottomNavBar(navController: NavHostController){
    val screens = listOf(
        BottomBar.HomeUI,
        BottomBar.DonationUI,
        BottomBar.PaymentUI,
        BottomBar.ProfileUI
    )

    val navStackBackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navStackBackEntry?.destination

    Row(
        modifier = Modifier
            .padding(start = 10.dp, end = 10.dp, top = 8.dp, bottom = 8.dp)
            .background(Color.Transparent)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        screens.forEach { screen ->
            AddItemToBackStack(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }

}

@Composable
fun AddItemToBackStack(
    screen: BottomBar,
    currentDestination: NavDestination?,
    navController: NavHostController
){

    val selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true

    val colorBg = Color(
        0,
        150,
        106
    )
    val background =
        if (selected) colorBg else Color.Transparent

    val contentColor =
        if (selected) Color.White else Color.Black

    Box(
        modifier = Modifier
            .height(40.dp)
            .clip(CircleShape)
            .background(background)
            .clickable(onClick = {
                navController.navigate(screen.route) {
                    popUpTo(navController.graph.findStartDestination().id)
                    launchSingleTop = true
                }
            })
    ) {
        Row(
            modifier = Modifier
                .padding(start = 10.dp, end = 10.dp, top = 8.dp, bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Icon(
                imageVector = if (selected) screen.icon_focused else screen.icon,
                contentDescription = "icon",
                tint = contentColor
            )
            AnimatedVisibility(visible = selected) {
                Text(
                    text = screen.title,
                    color = contentColor
                )
            }
        }
    }
}
