package com.udenyijoshua.foodbankcompose.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.materialIcon
import androidx.compose.material.icons.rounded.AddCircle
import androidx.compose.material.icons.rounded.CreditCard
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Inbox
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Star
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBar(
    val route: String,
    val title: String,
    val icon: ImageVector,
    val icon_focused: ImageVector
) {

    // for home
    object HomeUI: BottomBar(
        route = "HomeUI",
        title = "Home",
        icon = Icons.Rounded.Home,
        icon_focused = Icons.Rounded.Person
    )

    // for report
    object DonationUI: BottomBar(
        route = "DonationUI",
        title = "Donate",
        icon = Icons.Rounded.AddCircle,
        icon_focused = Icons.Rounded.Inbox
    )

    // for report
    object PaymentUI: BottomBar(
        route = "PaymentUI",
        title = "Payment",
        icon = Icons.Rounded.CreditCard,
        icon_focused = Icons.Rounded.CreditCard
    )

    object ProfileUI: BottomBar(
        route = "ProfileUI",
        title = "Profile",
        icon = Icons.Rounded.Person,
        icon_focused = Icons.Rounded.Person
    )

}