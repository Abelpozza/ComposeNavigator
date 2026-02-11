package com.abel.jetpackprojeto


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abel.jetpackprojeto.presentation.components.OptionButton
import com.abel.jetpackprojeto.presentation.components.TopBackgroundWindow
import com.abel.jetpackprojeto.presentation.components.openLink
import com.abel.jetpackprojeto.ui.theme.JETPACKProjetoTheme
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch

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
fun RedirectOptionScreen() {

    val context = LocalContext.current
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope ()

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
        containerColor = Color.Black
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(24.dp),
        ){}

    }


        TopBackgroundWindow(
            modifier = Modifier.fillMaxSize(),
            backgroundColor = Color.DarkGray,
            contentColor = Color.DarkGray
        ) {

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
                    fontWeight = FontWeight.Bold
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

                        scope.launch {
                            val result = snackbarHostState.showSnackbar(
                                message = "Abrindo Github \uD83D\uDE80",
                                actionLabel =  "Desfazer",
                                duration = SnackbarDuration.Long
                            )
                            if (result == SnackbarResult.ActionPerformed) {
                                snackbarHostState.showSnackbar("Ação Desfeita!")
                            }
                        }
                    }
                )

                Spacer(modifier = Modifier.height(16.dp))

                OptionButton(
                    text = "📱 Contato WhatsApp",
                    containerColor = Color(0xFF1C1C1C),
                    contentColor = Color(0xFFB8860B),
                    onClick = {
                        openLink(
                            context,
                            "https://wa.me/5548999999999"
                        )
                    }
                )

                Spacer(modifier = Modifier.height(16.dp))

                OptionButton(
                    text = "💼 LinkedIn",
                    containerColor = Color(0xFF1C1C1C),
                    contentColor = Color(0xFFB8860B),
                    onClick = {
                        openLink(
                            context,
                            "https://www.linkedin.com/in/abel-antônio-pozza/"
                        )
                    }
                )
            }
        }
    }









