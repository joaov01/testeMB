package com.joaovitor.coinappmb.ui.view

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.gson.Gson
import com.joaovitor.coinappmb.HomeViewModel
import com.joaovitor.coinappmb.R
import com.joaovitor.coinappmb.repository.RepositoryImpl
import com.joaovitor.coinappmb.ui.model.response.Exchange

@Composable
fun HomeScreen(navController: NavController, viewModel: HomeViewModel) {

    val data by viewModel.data.observeAsState(mutableListOf())
    val isLoading by viewModel.isLoading.observeAsState(false)
    val isError by viewModel.isError.observeAsState(false)
    viewModel.fetchExchange()


    Scaffold { paddingValues ->

        Column(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(paddingValues)
        ) {

            Text(
                text = stringResource(R.string.text_title_list_cripto),
                Modifier
                    .padding(start = 16.dp, top = 20.dp, end = 16.dp, bottom = 24.dp)
                    .align(Alignment.CenterHorizontally),
                fontSize = 24.sp
            )

            if (isLoading) {
                Box(
                    Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            } else {

                if (isError){
                    Box(
                        Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ){
                        Text(text = stringResource(R.string.text_generic_error),
                            Modifier.padding(start = 16.dp, end = 16.dp),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center)
                    }
                }

                LazyColumn(
                    Modifier
                        .padding(top = 8.dp, bottom = 16.dp)
                        .fillMaxWidth()
                ) {

                    itemsIndexed(data) { index, e ->
                        val backgroundColor = if (index % 2 == 0) Color.LightGray else Color.White
                        CoinListItem(exchange = e,
                            modifier = Modifier
                                .background(backgroundColor)
                                .clickable {
                                    val exchangeJson = Uri.encode(Gson().toJson(e))
                                    navController.navigate("details/$exchangeJson")
                                }
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    HomeScreen(navController = rememberNavController(), HomeViewModel(RepositoryImpl()))
}