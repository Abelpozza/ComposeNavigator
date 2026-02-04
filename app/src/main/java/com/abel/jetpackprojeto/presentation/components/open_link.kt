package com.abel.jetpackprojeto.presentation.components

import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.core.net.toUri



fun openLink(
    context: android.content.Context,
    url: String
) {
    val intent = Intent(Intent.ACTION_VIEW, url.toUri())
    context.startActivity(intent)
}