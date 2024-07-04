package com.joaovitor.coinappmb

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.gson.Gson
import com.joaovitor.coinappmb.repository.RepositoryImpl
import com.joaovitor.coinappmb.ui.model.response.Exchange
import com.joaovitor.coinappmb.ui.theme.CoinAppMBTheme
import com.joaovitor.coinappmb.ui.view.DetailsScreen
import com.joaovitor.coinappmb.ui.view.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoinAppMBTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyApp()
                }
            }
        }
    }
}


@Composable
fun MyApp() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "home") {
        composable("home") { HomeScreen(navController, HomeViewModel(RepositoryImpl())) }
        composable(route = "details/{exchangeJson}",
            arguments = listOf(navArgument("exchangeJson") { type = NavType.StringType })
        ) { backStackEntry ->
            val exchangeJson = backStackEntry.arguments?.getString("exchangeJson")
            val exchange = Gson().fromJson(Uri.decode(exchangeJson), Exchange::class.java)
            DetailsScreen(navController, exchange)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CoinAppMBTheme {
        MyApp()
    }
}