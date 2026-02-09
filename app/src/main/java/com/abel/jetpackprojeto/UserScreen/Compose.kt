package com.abel.jetpackprojeto.UserScreen

import androidx.compose.runtime.Composable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import com.abel.jetpackprojeto.UserViewModel.UserViewModel


@Composable
fun UserScreen(viewModel: UserViewModel = androidx.lifecycle.viewmodel.compose.viewmodel()) {

    if (viewModel.loading) {
        CircularProgressIndicator()
    } else {
        LazyColumn {
            items(viewModel..users) { user ->
                Text(
                    text = user.name,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }

}
}