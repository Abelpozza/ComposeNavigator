package com.abel.jetpackprojeto.presentation.components

import android.content.Context
import android.content.Intent
import android.net.Uri

fun openLink(context: Context, url: String) {

    val intent = Intent(Intent.ACTION_VIEW).apply {
        data = Uri.parse(url)
    }

    context.startActivity(intent)
}