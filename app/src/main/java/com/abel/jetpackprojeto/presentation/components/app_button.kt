package com.abel.jetpackprojeto.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import org.w3c.dom.Text

@Composable
fun appButton(){
    val context = LocalContext.current
    Modifier
        .fillMaxSize()
        .padding(25.dp)
        .background(Color.Gray)
        .width(25.dp)

    // falta a URL aqui //
    }