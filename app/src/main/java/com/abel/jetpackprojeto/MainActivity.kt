package com.abel.jetpackprojeto


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abel.jetpackprojeto.ui.theme.JETPACKProjetoTheme
import java.net.URL
import androidx.core.net.toUri
import com.abel.jetpackprojeto.presentation.components.OptionButton
import com.abel.jetpackprojeto.presentation.components.TopBackgroundWindow
import com.abel.jetpackprojeto.presentation.components.openLink

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            JETPACKProjetoTheme {
                RedirectOptionScreen()
            }
        }
    }
}

@Composable
fun RedirectOptionScreen(){
    val context = LocalContext.current

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Black
    ) {
        TopBackgroundWindow (  modifier = Modifier.fillMaxSize(),
            backgroundColor = Color.DarkGray,
            contentColor = Color.DarkGray){
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                Text(
                    text = "Boas-vindas, Senhores!",
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.offset(-20.dp)
                )
                Spacer(modifier = Modifier.height(30.dp))

                OptionButton(
                    text = "📂 Meu Repositório",
                    containerColor = Color(0xFF1C1C1C),
                    contentColor = Color(0xFFB8860B),
                    onClick = {
                        openLink(
                            context,
                            "https://github.com/Abelpozza"
                        )
                    }
                )

                Spacer(modifier = Modifier.height(16.dp))

                OptionButton(
                    text = "\uD83D\uDCF2 Contato",
                    containerColor = Color(0xFF1C1C1C),
                    contentColor = Color(0xFFB8860B),
                    onClick = {
                        openLink(
                            context,
                            "COLOCAR LINK DO WHATSAPP AQUI"
                        )
                    }
                )
                Spacer(modifier = Modifier.height(16.dp))

                OptionButton(
                    text = "\uD83D\uDC63 Linkedin",
                    containerColor = Color(0xFF1C1C1C),
                    contentColor = Color(0xFFB8860B),
                    onClick = {
                        openLink(
                            context,
                            url = "https://www.linkedin.com/in/abel-antônio-pozza/"
                        )
                    }
                )
            }
        }

    }
}









