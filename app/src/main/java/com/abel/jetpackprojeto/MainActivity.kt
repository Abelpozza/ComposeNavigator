package com.abel.jetpackprojeto

import android.R
import android.os.Bundle
import android.provider.CalendarContract
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Build
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abel.jetpackprojeto.ui.theme.JETPACKProjetoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JETPACKProjetoTheme {
                Home()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Comece agora!", color = Color.Green)

                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Black
                ),
                actions = {
                    Icon(
                        imageVector = Icons.Rounded.Build,
                        contentDescription = null,
                        tint = Color.Yellow
                    )
                    Icon(
                        imageVector = Icons.Rounded.Lock,
                        contentDescription = null,
                        tint = Color.Green
                    )
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = Color.Black
            ) {
                BottomRightIcons()
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(Color.Black),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Conteúdo da tela", color = Color.Green, fontSize = 30.sp)
            Text(text = "Abel Antônio Pozza", color = Color.White)
            Text(text = "Luiz Eduardo Pozza", color = Color.Yellow)
        }
    }
}

@Composable
fun BottomRightIcons() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 20.dp)
            .background (Color.Black),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Rounded.Home,
            contentDescription = "Home",
            tint = Color.Yellow,
            modifier = Modifier.padding(end = 16.dp)
        )

        Icon(
            imageVector = Icons.Rounded.Build,
            contentDescription = "Configurações",
            tint = Color.Green
        )
    }
}


@Preview(showBackground = true)
@Composable
fun HomePreview() {
    JETPACKProjetoTheme {
        Home()
    }
}
