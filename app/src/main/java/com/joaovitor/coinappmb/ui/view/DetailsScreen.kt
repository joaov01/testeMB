package com.joaovitor.coinappmb.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.joaovitor.coinappmb.R
import com.joaovitor.coinappmb.ui.model.response.Exchange
import com.joaovitor.coinappmb.ui.model.toBrazilianDateFormat
import com.joaovitor.coinappmb.utils.MockPreview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(navController: NavController, exchange: Exchange) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(exchange.name) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Voltar"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->

        Column(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .verticalScroll(rememberScrollState())
                .padding(paddingValues)) {

            Image(
                painter = painterResource(id = R.drawable.ic_coin_vector),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
                    .size(160.dp)
            )

            Text(text = stringResource(R.string.text_website),
                Modifier.padding(start = 16.dp, top = 32.dp),
                fontSize = 20.sp, fontWeight = FontWeight.Bold)

            Text(text = exchange.website ?: "",
                Modifier.padding(start = 16.dp),
                fontSize = 20.sp)

            Text(text = stringResource(R.string.text_quote_start),
                Modifier.padding(start = 16.dp, top = 16.dp),
                fontSize = 20.sp, fontWeight = FontWeight.Bold)

            Text(text = exchange.data_quote_start.toBrazilianDateFormat() ?: "não informado",
                Modifier.padding(start = 16.dp),
                fontSize = 20.sp)


            Text(text = stringResource(R.string.text_quote_end),
                Modifier.padding(start = 16.dp, top = 16.dp),
                fontSize = 20.sp, fontWeight = FontWeight.Bold)

            Text(text = exchange.data_quote_end.toBrazilianDateFormat() ?: "não informado",
                Modifier.padding(start = 16.dp),
                fontSize = 20.sp)

            Text(text = stringResource(R.string.text_orderbook_start),
                Modifier.padding(start = 16.dp, top = 16.dp),
                fontSize = 20.sp, fontWeight = FontWeight.Bold)

            Text(text = exchange.data_orderbook_start.toBrazilianDateFormat() ?: "",
                Modifier.padding(start = 16.dp),
                fontSize = 20.sp)

            Text(text = stringResource(R.string.text_orderbook_end),
                Modifier.padding(start = 16.dp, top = 16.dp),
                fontSize = 20.sp, fontWeight = FontWeight.Bold)

            Text(text = exchange.data_orderbook_end.toBrazilianDateFormat() ?: "",
                Modifier.padding(start = 16.dp),
                fontSize = 20.sp)

            Text(text = stringResource(R.string.text_trade_start),
                Modifier.padding(start = 16.dp, top = 16.dp),
                fontSize = 20.sp, fontWeight = FontWeight.Bold)

            Text(text = exchange.data_trade_start.toBrazilianDateFormat() ?: "",
                Modifier.padding(start = 16.dp),
                fontSize = 20.sp)

            Text(text = stringResource(R.string.text_trade_end),
                Modifier.padding(start = 16.dp, top = 16.dp),
                fontSize = 20.sp, fontWeight = FontWeight.Bold)

            Text(text = exchange.data_trade_end.toBrazilianDateFormat() ?: "",
                Modifier.padding(start = 16.dp),
                fontSize = 20.sp)


            Text(text = stringResource(R.string.text_symbols_count),
                Modifier.padding(start = 16.dp, top = 16.dp),
                fontSize = 20.sp, fontWeight = FontWeight.Bold)

            Text(text = exchange.data_symbols_count.toString() ?: "",
                Modifier.padding(start = 16.dp),
                fontSize = 20.sp)

            Text(text = stringResource(R.string.text_volume_one_day_usd),
                Modifier.padding(start = 16.dp, top = 16.dp),
                fontSize = 20.sp, fontWeight = FontWeight.Bold)

            Text(text = exchange.volume_1day_usd.toString(),
                Modifier.padding(start = 16.dp),
                fontSize = 20.sp)

            Text(text = stringResource(R.string.text_volume_one_hour_usd),
                Modifier.padding(start = 16.dp, top = 16.dp),
                fontSize = 20.sp, fontWeight = FontWeight.Bold)

            Text(text = exchange.volume_1hrs_usd.toString(),
                Modifier.padding(start = 16.dp),
                fontSize = 20.sp)

            Text(text = stringResource(R.string.text_volume_one_month_usd),
                Modifier.padding(start = 16.dp, top = 16.dp),
                fontSize = 20.sp, fontWeight = FontWeight.Bold)

            Text(text = exchange.volume_1mth_usd.toString(),
                Modifier.padding(start = 16.dp, bottom = 24.dp),
                fontSize = 20.sp)

        }
    }
}

@Preview
@Composable
fun PreviewDetailsScreen(){
    DetailsScreen(navController = rememberNavController(),
        MockPreview.exchange)
}