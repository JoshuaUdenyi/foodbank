package com.udenyijoshua.foodbankcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.udenyijoshua.foodbankcompose.ui.theme.FoodBankComposeTheme
import android.graphics.Color as AndroidColor
import androidx.compose.ui.graphics.Color as ComposeColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(
                AndroidColor.TRANSPARENT, AndroidColor.TRANSPARENT
            ),
            navigationBarStyle = SystemBarStyle.light(
                AndroidColor.TRANSPARENT, AndroidColor.TRANSPARENT
            )
        )

        super.onCreate(savedInstanceState)
        setContent {
            FoodBankComposeTheme {
                // A surface container using the 'background' color from the theme
                MainAppComponent()
            }


        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainAppComponent(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            TopAppBar(title = {
                Text(
                    text = "Foodbank.", color = ComposeColor.Black, fontWeight = FontWeight.Bold
                )
            }, actions = {
                Icon(
                    imageVector = Icons.Rounded.Notifications,
                    contentDescription = "notification",
                    tint = ComposeColor.Black,
                    modifier = modifier.padding(end = 10.dp)
                )
            }, colors = TopAppBarDefaults.topAppBarColors(
                containerColor = ComposeColor.Transparent
            ), modifier = modifier.fillMaxWidth()
            )

            // Search Bar

            SearchBar()
            HorizontalCard()
            ChipList()
        }
    }
}

@Composable
fun SearchBar(modifier: Modifier = Modifier) {
    var searchText by remember { mutableStateOf("") }
    OutlinedTextField(
        value = searchText,
        onValueChange = { searchText = it },
        modifier = modifier
            .fillMaxWidth()
            .width(200.dp)
            .height(60.dp),
        textStyle = LocalTextStyle.current.copy(fontSize = 14.sp),
        placeholder = { Text("Search Category") },
        singleLine = true,
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color(0, 150, 106),
            unfocusedIndicatorColor = Color(216, 238, 233),
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HorizontalCard(modifier: Modifier = Modifier) {
        OutlinedCard(
            onClick = {},
            modifier = modifier,
            border = BorderStroke(1.dp, color = Color(216, 238, 233)),
            colors = CardDefaults.outlinedCardColors(
                containerColor = Color.Transparent
            ),
        ) {

        Column(
            modifier = modifier
                .padding(16.dp)
                .clip(RoundedCornerShape(12.dp))
        ) {
            Image(
                painter = painterResource(id = R.drawable.hero_image1),
                contentDescription = "Featured-Image-Desc",
                modifier = modifier
                    .clip(RoundedCornerShape(12.dp))
                    .fillMaxWidth()
                    .height(150.dp),
                contentScale = ContentScale.Crop
            )

            Text(
                text = "Fresh Food for Improving lives in Africa then he",
                fontWeight = FontWeight.Bold,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, bottom = 10.dp),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            ProgressBarWithText()

            Row {

                Row {
                    Column {
                        Text(text = "Donations Raised")
                        Text(text = "$540900")
                    }
                }

                Row {
                    Text(text = "8 Hours left")
                }

            }
        }
        }
    }

@Composable
fun ProgressBarWithText(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .widthIn(min = 30.dp),
        verticalAlignment = Alignment.CenterVertically // Align items vertically in the center
    ) {
        Box(
            modifier = Modifier
                .weight(1f) // Occupy the remaining space
                .height(10.dp)
        ) {
            // Background of the ProgressBar
            Box(
                modifier = Modifier
                    .fillMaxSize(1f)
                    .clip(RoundedCornerShape(9.dp))
                    .background(
                        color = ComposeColor(
                            244,
                            244,
                            244
                        )
                    ) // Assuming Purple40 is a shade of gray
            )
            // Progress of the ProgressBar
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.5f) // Assuming 50% progress for demonstration
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(9.dp))
                    .background(color = ComposeColor(0, 150, 106))
            )
        }
        Spacer(modifier = Modifier.width(8.dp)) // Add some space between progress bar and text
        Text(
            text = "80%",
            fontSize = 14.sp,
            color = ComposeColor.Black
        )
    }
}

@Composable
fun VerticalCard(modifier: Modifier = Modifier) {

}

@Composable
fun ChipList(modifier: Modifier = Modifier){
    Column {
        Text(text = "Category")
        
        Row (
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            categoryItems.forEach { 
                Chip(chipData = it)
            }
        }
    }
}

@Composable
fun Chip(chipData: String, modifier: Modifier = Modifier) {
    var selected by remember { mutableStateOf(false) }
    FilterChip(
        selected = selected ,
        onClick = { selected = !selected },
        label = { Text(text = chipData)},
        leadingIcon = if (selected) {
            {
                Icon(
                    imageVector = Icons.Filled.Done,
                    contentDescription = "Done icon",
                    modifier = modifier.size(FilterChipDefaults.IconSize)
                )
            }
        } else {
            null
        },
    )
}

@Composable
fun BottomNavigation(modifier: Modifier = Modifier) {

}

val categoryItems = listOf<String>(
    "Food",
    "Medcine",
    "Education",
    "Clothings",
    "Girl-Health",
    "Drugs"
)


@Preview()
@Composable
fun AppPreview() {
    FoodBankComposeTheme {
        MainAppComponent()
    }
}