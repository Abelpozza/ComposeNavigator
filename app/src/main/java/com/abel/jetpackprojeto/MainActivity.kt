package com.abel.jetpackprojeto

import android.R
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abel.jetpackprojeto.ui.theme.JETPACKProjetoTheme

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

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Black
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
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(30.dp))

            OptionButton(
                text = "📂 Meu Repositório",
                onClick = {
                    openLink(
                        context,
                        "https://github.com/Abelpozza"
                    )
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            OptionButton(
                text = "📞 Contato",
                onClick = {
                    openLink(
                        context,
                        "COLOCAR LINK DO WHATSAPP AQUI")
                }
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    OptionButton(
                        text = "\uD83D\uDC63 Biografia",
                        onClick = {
                            openLink(
                                context,
                                    url = "https://www.linkedin.com/in/abel-antônio-pozza/")
                        }
                                )
                      }
                }

        }



@Composable
fun OptionButton(
    text: String,
    onClick: () -> Unit,
    containerColor: Color = MaterialTheme.colorScheme.primary,
    contentColor: Color = MaterialTheme.colorScheme.onPrimary
) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor

        ),
        shape = MaterialTheme.shapes.medium
    ) {
        Text(
            text = text,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

private fun openLink(
    context: android.content.Context,
    url: String
) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    context.startActivity(intent)
}
