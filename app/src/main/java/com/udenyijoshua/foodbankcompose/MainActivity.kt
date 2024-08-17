package com.udenyijoshua.foodbankcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.udenyijoshua.foodbankcompose.screens.StartDestination
import com.udenyijoshua.foodbankcompose.screens.authscreen.Login
import com.udenyijoshua.foodbankcompose.screens.authscreen.SignUp
import com.udenyijoshua.foodbankcompose.ui.theme.FoodBankComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            FoodBankComposeTheme {
                StartDestination()
//                SignUp()
//               Login()
            }
        }
    }
}