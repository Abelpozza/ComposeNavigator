import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.abel.jetpackprojeto.presentation.screen.ViewmodelApi.UserViewModel

@Composable
fun UserScreen(viewModel: UserViewModel = viewModel()) {

    val users by viewModel.post
    val loading by viewModel.isLoading

    LaunchedEffect(Unit) {
        viewModel.loadPosts()
    }

    if (loading) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        LazyColumn {
            items(users) { user ->
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = user.body,
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(text = user.title)
                }
            }
        }
    }
}