package com.udenyijoshua.foodbankcompose.screens

import android.annotation.SuppressLint
import android.graphics.Color.rgb
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.udenyijoshua.foodbankcompose.R


data class DonationAmount(val amount: String, val isSelected: Boolean = false)
data class PaymentOption(val name: String, val isSelected: Boolean = false)

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DonationUI(modifier: Modifier = Modifier) {
    var selectedDonationAmount by remember {
        mutableStateOf<DonationAmount?>(null)
    }
    Scaffold(bottomBar = {
        PayConfirmButton()
    }) {

        Column {
            DonationProjectCard()
            Text("Select Amount", modifier = modifier.padding(top = 16.dp, bottom = 16.dp))

            val donationAmounts = listOf(
                DonationAmount("$20"),
                DonationAmount("$50"),
                DonationAmount("$10"),
                DonationAmount("$100")
            )

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(donationAmounts) { amount ->
                    DonationAmountItem(amount = amount,
                        isSelected = amount == selectedDonationAmount,
                        onItemClick = {
                            selectedDonationAmount = when {
                                amount == selectedDonationAmount -> null
                                else -> it
                            }
                        })
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            CustomAmountInput()

            Text("Select Payment", modifier = modifier.padding(top = 16.dp, bottom = 16.dp))
            PaymentList()
        }
    }
}

@Composable
fun DonationProjectCard(modifier: Modifier = Modifier) {
    OutlinedCard(
        onClick = {},
        modifier = modifier,
        border = BorderStroke(1.dp, color = Color(216, 238, 233)),
        colors = CardDefaults.outlinedCardColors(
            containerColor = Color.Transparent
        ),
    ) {

        Row(
            modifier = modifier
                .padding(16.dp)
                .clip(RoundedCornerShape(12.dp))
        ) {
            Image(
                painter = painterResource(id = R.drawable.hero_image1),
                contentDescription = "Featured-Image-Desc",
                modifier = modifier
                    .clip(RoundedCornerShape(12.dp))
                    .height(80.dp)
                    .width(120.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = modifier.width(16.dp))

            Column {
                Text(
                    text = "Fresh Food for Improving lives in Africa then he",
                    fontWeight = FontWeight.Bold,
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp, bottom = 10.dp),
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }


}

@Composable
fun DonationAmountItem(
    amount: DonationAmount,
    isSelected: Boolean,
    onItemClick: (DonationAmount) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .size(100.dp)
            .border(1.dp, color = Color.DarkGray, shape = RoundedCornerShape(16.dp))
            .background(color = if (isSelected) Color(rgb(0, 150, 106)) else Color.Transparent)
            .clickable { onItemClick(amount) }, contentAlignment = Alignment.Center
    ) {
        Text(
            text = amount.amount,
            color = if (isSelected) Color.White else Color.Black,
        )
    }
}

@Composable
fun CustomAmountInput(
    modifier: Modifier = Modifier
) {
    var text by remember { mutableStateOf("") }

    BasicTextField(
        value = text,
        onValueChange = { newText -> text = newText },
        textStyle = TextStyle(
            color = Color.Black, // Text color inside the field
            textAlign = TextAlign.Center
        ),
        decorationBox = { innerTextField ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                if (text.isEmpty()) {
                    Text(
                        text = "Enter Price Manually",
                        style = MaterialTheme.typography.bodyLarge.copy(color = Color.Gray)
                    )
                }
                innerTextField()
            }
        },
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(Color(rgb(244, 244, 244)), shape = RoundedCornerShape(16.dp))
    )
}


@Composable
fun PayConfirmButton(modifier: Modifier = Modifier) {
    Button(
        onClick = {},
        modifier = modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(rgb(0, 150, 106))
        )
    ) {
        Text(
            text = "Pay & Confirm"
        )
    }
}

@Composable
fun PaymentList(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .size(60.dp)
                .padding(bottom = 10.dp)
                .border(1.dp, color = Color.DarkGray, shape = RoundedCornerShape(16.dp))
                .clickable {  }
                .clip(shape = RoundedCornerShape(16.dp)), contentAlignment = Alignment.CenterStart
        ) {
            Text(text = "PayPal", modifier = modifier.padding(start = 16.dp))
        }

        Box(
            modifier = modifier
                .fillMaxWidth()
                .size(60.dp)
                .padding(bottom = 10.dp)
                .border(1.dp, color = Color.DarkGray, shape = RoundedCornerShape(16.dp))
                .clickable {  }
                .clip(shape = RoundedCornerShape(16.dp)), contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = "Card",
                modifier = modifier.padding(start = 16.dp)
            )
        }

    }
}