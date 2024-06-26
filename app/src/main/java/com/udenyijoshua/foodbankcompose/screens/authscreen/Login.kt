package com.udenyijoshua.foodbankcompose.screens.authscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.udenyijoshua.foodbankcompose.ui.theme.FoodBankComposeTheme
import javax.security.auth.login.LoginException

@Composable
fun Login(modifier: Modifier = Modifier){
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Surface(
            onClick = {},
            modifier = modifier.weight(6f),
            color = Color.DarkGray
        ) {
            //Surface Container Column
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth().clickable(enabled = false, null, null, {})
            ) {
                Text(
                    text = "FoodBank..",
                    style = TextStyle(
                        fontSize = 52.sp,
                        fontWeight = FontWeight.ExtraBold,
                        fontFamily = FontFamily.Cursive
                    ),
                    color = Color.Green
                )
            }
        }
        Surface(){
            Column(
                modifier = modifier.padding(start = 8.dp, end = 8.dp)
            ) {
                var isChecked  by remember {

                    mutableStateOf(false)
                }
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = modifier.fillMaxWidth()
                ) {

                    Checkbox(
                        checked = isChecked,
                        onCheckedChange = { isChecked = it}
                    )
                    Text(
                        text = "I agree to the Terms of Service"
                    )
                }

                if(isChecked){
                    Button(
                        onClick = { /*TODO*/ },
                        enabled = true,
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp),
                        shape = RoundedCornerShape(4.dp)
                    ) {
                        Text(text = "Continue with Google")
                    }
                }else{
                    Button(
                        onClick = { /*TODO*/ },
                        enabled = false,
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp),
                        shape = RoundedCornerShape(4.dp)
                    ) {
                        Text(text = "Continue with Google")
                    }
                }
            }

        }
    }

}








@Preview
@Composable
fun LoginPreview(){
    FoodBankComposeTheme {
        //StartDestination()
        Login()
    }
}