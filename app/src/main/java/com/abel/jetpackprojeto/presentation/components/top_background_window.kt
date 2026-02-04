package com.abel.jetpackprojeto.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun TopBackgroundWindow(
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.Gray,
    contentColor: Color = Color.Gray,

    content: @Composable () -> Unit,

) {
    Surface(
      modifier = modifier,
       color = backgroundColor,
        contentColor = contentColor,

    ) {
        content()
    }


    Box(
        modifier = modifier.fillMaxSize()
        .background(Color((0x66000000)))

    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color((0x66000000)))
        )
        content()

    }
}