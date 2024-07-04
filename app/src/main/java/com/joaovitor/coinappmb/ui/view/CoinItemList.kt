package com.joaovitor.coinappmb.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.joaovitor.coinappmb.R
import com.joaovitor.coinappmb.ui.model.response.Exchange
import com.joaovitor.coinappmb.utils.MockPreview

@Composable
fun CoinListItem(exchange: Exchange, modifier: Modifier) {

    Column {

        Row(modifier = modifier.fillMaxWidth()) {

            Column(
                Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically)) {
                Image(
                    painter = painterResource(id = R.drawable.ic_coin_vector),
                    contentDescription = null,
                    modifier = Modifier
                        .size(48.dp)
                        .padding(8.dp)
                )
            }

            Column(Modifier.weight(8f)) {

                Row {
                    Text(
                        text = "ID",
                        modifier = Modifier
                            .padding(start = 16.dp, top = 16.dp)
                            .weight(1f),

                        )

                    Text(
                        text = "Nome",
                        modifier = Modifier
                            .padding(top = 16.dp)
                            .weight(1f)
                    )

                    Text(
                        text = "Vol. 1 dia $",
                        modifier = Modifier
                            .padding(top = 16.dp)
                            .weight(1f)
                    )
                }

                Row {
                    Text(
                        text = exchange.exchange_id,
                        modifier = Modifier
                            .padding(start = 16.dp, bottom = 8.dp)
                            .weight(1f)
                    )

                    Text(
                        text = exchange.name,
                        modifier = Modifier
                            .weight(1f)
                    )

                    Text(
                        text = exchange.volume_1day_usd.toString(),
                        modifier = Modifier
                            .weight(1f),
                        textAlign = TextAlign.Start
                    )
                }
            }

            Column(
                Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically)) {
                Image(
                    painter = painterResource(id = R.drawable.ic_arrow_right),
                    contentDescription = null,
                    modifier = Modifier
                        .size(48.dp)
                        .padding(8.dp)
                )
            }
        }

        HorizontalDivider(color = Color.Gray, thickness = 1.dp)
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewCoinListItem() {
    CoinListItem(
        MockPreview.exchange, Modifier
    )
}

