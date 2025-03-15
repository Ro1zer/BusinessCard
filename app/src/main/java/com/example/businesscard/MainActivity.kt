package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = MaterialTheme.colorScheme.secondaryContainer
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp() {

    GeneralPanel(
        painterResource(R.drawable.android_logo),
        stringResource(R.string.full_name),
        stringResource(R.string.desc)
    )
    ContactPanel(
        stringResource(R.string.phone_number),
        stringResource(R.string.email),
        stringResource(R.string.git_hub_nickname)
    )
}

@Composable
fun GeneralPanel(
    icon: Painter,
    fullName: String,
    description: String,
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(bottom = 50.dp)
    ) {
        Image(
            painter = icon,
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .background(MaterialTheme.colorScheme.onSecondaryContainer)
                .size(100.dp)
                .padding(5.dp)
        )
        Text(
            text = fullName,
            textAlign = TextAlign.Center,
            fontSize = MaterialTheme.typography.titleLarge.fontSize,
            fontFamily = MaterialTheme.typography.titleLarge.fontFamily,
            color = MaterialTheme.colorScheme.onSecondaryContainer,
            modifier = Modifier.padding(top = 16.dp, bottom = 16.dp),
        )
        Text(
            text = description,
            textAlign = TextAlign.Center,
            fontSize = MaterialTheme.typography.labelLarge.fontSize,
            fontFamily = MaterialTheme.typography.labelLarge.fontFamily,
            fontWeight = MaterialTheme.typography.labelLarge.fontWeight,
            color = MaterialTheme.colorScheme.onSecondaryContainer,
        )
    }
}

@Composable
fun ContactPanel(
    phoneNumber: String,
    email: String,
    gitHubNickname: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,
    ) {
        ContactPlace(
            Icons.Rounded.Phone,
            phoneNumber,
            Modifier.padding(bottom = 16.dp)
        )
        ContactPlace(
            Icons.Rounded.Email,
            email,
            Modifier.padding(bottom = 16.dp)
        )
        ContactPlace(
            Icons.Rounded.AccountCircle,
            gitHubNickname,
            Modifier.padding(bottom = 100.dp)
        )
    }
}

@Composable
fun ContactPlace(
    icon: ImageVector,
    value: String,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Spacer(
            Modifier.weight(1f)
        )
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.weight(1f),
            tint = MaterialTheme.colorScheme.onSecondaryContainer
        )
        Text(
            text = value,
            textAlign = TextAlign.Left,
            fontSize = MaterialTheme.typography.labelSmall.fontSize,
            fontFamily = MaterialTheme.typography.labelSmall.fontFamily,
            fontWeight = MaterialTheme.typography.labelSmall.fontWeight,
            color = MaterialTheme.colorScheme.onSecondaryContainer,
            modifier = Modifier
                .weight(3f)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = MaterialTheme.colorScheme.secondaryContainer
    ) {
        BusinessCardApp()
    }
}