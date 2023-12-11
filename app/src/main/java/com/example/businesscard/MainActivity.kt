package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.sharp.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize().background(color = Color(0f,1f,0.1f,0.1f))
    ) {
        Spacer(modifier = modifier.weight(1f))
        profileInfo()
        Spacer(modifier = modifier.weight(0.5f))
        contactInfo(modifier = modifier.weight(1f))
    }
}

@Composable
fun profileInfo(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile_photo),
            contentDescription = "Profile photo",
            modifier = modifier.clip(CircleShape)
        )
        Text(
            text = stringResource(R.string.profile_name),
            fontWeight = FontWeight.Bold,
            fontSize = 40.sp,
            modifier = modifier.padding(16.dp)
        )
        Text(
            text = stringResource(R.string.profile_title),
            color = Color.Blue
        )
    }
}

@Composable
fun contactInfo(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth().padding(start = 64.dp),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Row(
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(
                Icons.Filled.Phone,
                contentDescription = "mobile number",
                tint = Color.Blue
            )
            Text(
                text = stringResource(R.string.mobile_no),
                modifier = modifier.padding(start = 8.dp)
            )
        }
        Row(
            horizontalArrangement = Arrangement.Center
        )  {
            Icon(
                Icons.Outlined.AccountCircle,
                contentDescription = "Github",
                tint = Color.Blue
            )
            Text(
                text = stringResource(R.string.github),
                modifier = modifier.padding(start = 8.dp)
            )
        }
        Row(
            horizontalArrangement = Arrangement.Center
        )  {
            Icon(
                Icons.Outlined.Email,
                contentDescription = "email",
                tint = Color.Blue
            )
            Text(
                text = stringResource(R.string.email),
                modifier = modifier.padding(start = 8.dp)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}