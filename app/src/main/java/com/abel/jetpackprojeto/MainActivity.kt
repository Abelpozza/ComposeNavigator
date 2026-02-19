package com.abel.jetpackprojeto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.abel.jetpackprojeto.presentation.components.OptionButton
import com.abel.jetpackprojeto.presentation.components.TopBackgroundWindow
import com.abel.jetpackprojeto.presentation.components.openLink
import com.abel.jetpackprojeto.presentation.screen.PostsScreen
import com.abel.jetpackprojeto.presentation.screen.ViewmodelApi.UserViewModel
import com.abel.jetpackprojeto.presentation.viewmodel.RedirectViewModel
import com.abel.jetpackprojeto.ui.theme.JETPACKProjetoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            JETPACKProjetoTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {

        composable("home") {
            RedirectOptionScreen(navController)
        }

        composable("users") {
            UserScreen(navController)
        }

        composable(
            route = "posts/{userId}",
            arguments = listOf(
                navArgument("userId") { type = NavType.IntType }
            )
        ) { backStackEntry ->

            val userId = backStackEntry.arguments?.getInt("userId") ?: 0
            PostsScreen(userId = userId)
        }
    }
}

@Composable
fun RedirectOptionScreen(
    navController: NavController,
    viewModel: UserViewModel = viewModel()
) {

    val context = LocalContext.current
    val snackbarHostState = remember { SnackbarHostState() }
    val redirectViewModel: RedirectViewModel = viewModel()

    LaunchedEffect(Unit) {
        redirectViewModel.snackbarEvent.collect { message ->
            snackbarHostState.showSnackbar(message)
        }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
        containerColor = Color.Black
    ) { paddingValues ->

        TopBackgroundWindow(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            backgroundColor = Color.DarkGray,
            contentColor = Color.DarkGray
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
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
                        navController.navigate("users")
                    }
                )

                Spacer(modifier = Modifier.height(16.dp))

                OptionButton(
                    text = "📱 Contato WhatsApp",
                    containerColor = Color(0xFF1C1C1C),
                    contentColor = Color(0xFFB8860B),
                    onClick = {
                        openLink(context, "https://wa.me/5548999999999")
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
}

@Composable
fun UserScreen(
    navController: NavController,
    viewModel: UserViewModel = viewModel()
) {

    val users = viewModel.users.value
    val isLoading = viewModel.isLoading.value

    Scaffold(
        containerColor = Color.Black
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {

            Text(
                text = "Repositório",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            LaunchedEffect(Unit) {
                viewModel.loadUsers()
            }

            if (isLoading) {
                CircularProgressIndicator(color = Color.White)
            }

            Text(
                text = "Quantidade: ${users.size}",
                color = Color.Red
            )

            if (users.isNotEmpty()) {
                LazyColumn(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(users) { user ->
                        Card(
                            modifier = Modifier
                                .padding(8.dp)
                                .fillMaxWidth(),
                            onClick = {
                                navController.navigate("posts/${user.id}")
                            },
                            colors = CardDefaults.cardColors(
                                containerColor = Color(0xFF1C1C1C)
                            )
                        ) {
                            Column(modifier = Modifier.padding(16.dp)) {

                                Text(
                                    text = "${user.id}",
                                    style = MaterialTheme.typography.titleMedium,
                                    color = Color.Red
                                )

                                Spacer(modifier = Modifier.height(4.dp))

                                Text(
                                    text = user.username,
                                    style = MaterialTheme.typography.titleMedium,
                                    color = Color(0xFFB8860B)
                                )

                                Spacer(modifier = Modifier.height(4.dp))

                                Text(
                                    text = user.email,
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
