import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.abel.jetpackprojeto.data.model.Post
import com.abel.jetpackprojeto.presentation.screen.ViewmodelApi.PostViewModel
import com.abel.jetpackprojeto.presentation.state.UiState
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun PostsScreen(
    userId: Int,
    navController: NavController
) {

    val viewModel: PostViewModel = viewModel() //

    val state by viewModel.uiState.collectAsState()

    LaunchedEffect(userId) {
        viewModel.loadPostsByUser(userId)
    }

    Scaffold(
        containerColor = Color.Black
    ) { padding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {

            when (state) {

                is UiState.Loading -> {
                    CircularProgressIndicator(
                        color = Color.White,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }

                is UiState.Error -> {
                    Text(
                        text = "Erro ao carregar posts",
                        color = Color.White,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }

                is UiState.Success -> {

                    val posts =
                        (state as UiState.Success<List<Post>>).data

                    if (posts.isEmpty()) {
                        Text(
                            text = "Nenhum post encontrado",
                            color = Color.White,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    } else {

                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            Text(
                                text = "Posts do usuário $userId",
                                color = Color.White,
                                fontSize = 22.sp,
                                fontWeight = FontWeight.Bold
                            )

                            Spacer(modifier = Modifier.height(16.dp))

                            LazyColumn {
                                items(posts) { post ->

                                    Card(
                                        modifier = Modifier
                                            .padding(8.dp)
                                            .fillMaxWidth(),
                                        colors = CardDefaults.cardColors(
                                            containerColor = Color(0xFF1C1C1C)
                                        )
                                    ) {

                                        Column(
                                            modifier = Modifier.padding(16.dp)
                                        ) {

                                            Text(
                                                text = post.title,
                                                color = Color(0xFFB8860B),
                                                fontWeight = FontWeight.Bold
                                            )

                                            Spacer(
                                                modifier = Modifier.height(4.dp)
                                            )

                                            Text(
                                                text = post.body,
                                                color = Color.White
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}