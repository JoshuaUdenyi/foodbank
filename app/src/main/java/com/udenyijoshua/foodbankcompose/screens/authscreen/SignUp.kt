package com.udenyijoshua.foodbankcompose.screens.authscreen

// .... Imports
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun SignUp(modifier: Modifier = Modifier) {
    val longText = """
                Welcome!! 💐💐
                    
                Thank you for downloading FoodBank!. We are
                excited to have you go beyond the numbers

                Your journey to making impact on families and children Globally
                you will have the option to schedule your giving schedule to be daily, weekly, or monthly, depending on your goals.

                We are so grateful you're here and can't wait to have you join! 🙏

                Joshua, Paul & the FoodBank team
    """.trimIndent()

    Column(
        modifier = Modifier.fillMaxSize(), // Fill the entire available space
        verticalArrangement = Arrangement.Center // Push content to the bottom
    ) {
        Spacer(modifier = modifier.height(120.dp))
        WelcomeText(text = longText, modifier = Modifier.weight(1f)) // Allow WelcomeText to take up available space
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = modifier.fillMaxWidth()
        ) {
            ReUsableButton()

            Text(
                text = "Already have an account? Sign in",
                style = MaterialTheme.typography.bodyLarge,modifier = Modifier.padding(bottom = 32.dp) // Add bottom padding to the text
            )
        }
    }
}

@Composable
fun WelcomeText(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        modifier = modifier.padding(20.dp),
        style = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.W400,
            fontFamily = FontFamily.SansSerif
        ),
        maxLines = Int.MAX_VALUE
    )
}

@Composable
fun ReUsableButton(modifier: Modifier = Modifier) {
    Button(
        onClick = { /*TODO*/ },
        modifier = modifier
            .fillMaxWidth()
            .size(width = 200.dp, height = 105.dp)
            .padding(20.dp),
        shape = RoundedCornerShape(6.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Black,
        )// Use Material spacing
    ) {
        Text(text = "Start My Journey ➡️",
            style = MaterialTheme.typography.titleLarge,
            color = Color.White
        )
    }
}

@Preview
@Composable
fun PreviewScreen(){
    SignUp()
}