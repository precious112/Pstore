package com.precious.pstore

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(){
    val scrollState = rememberScrollState()
     val features= listOf(
        feature(R.drawable.pic1,"$250"),
         feature(R.drawable.pic2,"$300"),
         feature(R.drawable.pic3,"$350"),
         feature(R.drawable.pic4,"$360"),
         feature(R.drawable.pic5,"$200"),
         feature(R.drawable.pic6,"$400")
    )
    Box(modifier= Modifier
        .fillMaxSize()
        .background(color = Color(0xFFFFFFFF))
        .verticalScroll(rememberScrollState())
    ) {
       Column(
           verticalArrangement = Arrangement.Center,
           horizontalAlignment = Alignment.CenterHorizontally
       ) {
          Header()
           WelcomeSection()
           Features(features = features)
           AmazingSection()
           Latest(features = features)
       }
    }
}


@Composable
fun Header(){
    Box(modifier=Modifier.fillMaxWidth()) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp, 20.dp, 0.dp, 20.dp)
        ){
           Image(painter = painterResource(id = R.drawable.ic_list_6223), contentDescription ="menu",
           modifier = Modifier.size(20.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(200.dp, 0.dp, 0.dp, 0.dp)
            ){
                Image(painter = painterResource(id = R.drawable.ic_search), contentDescription ="search",
                    modifier = Modifier.size(20.dp)
                )
                Image(painter = painterResource(id = R.drawable.ic_shopping_bag_svgrepo_com), contentDescription ="Bag",
                    modifier = Modifier.size(20.dp))
            }
        }
    }
}

@Composable
fun WelcomeSection(){
    Box() {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(20.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color(0xFFc56200))
                .padding(horizontal = 15.dp, vertical = 20.dp)
                .fillMaxWidth()
        ) {
            Text(text = "Welcome!",
                style = MaterialTheme.typography.h3
            )
            Image(painter = painterResource(id = R.drawable.ic_refundpana), contentDescription = "logo",
                modifier = Modifier.size(140.dp)
            )
        }
    }
}

@Composable
fun Features(features:List<feature>){
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Features",
            style = MaterialTheme.typography.h2,
            modifier = Modifier.padding(10.dp)
        )
        LazyRow(
            contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 20.dp),
            modifier = Modifier.fillMaxHeight()
        ) {
            items(features.size) {
                FeatureItem(Feature = features[it])
            }
        }
    }
}

@Composable
fun FeatureItem(Feature:feature){
    Box(
        modifier = Modifier
            .height(240.dp)
            .width(150.dp)
            .padding(10.dp)
    ){
        Column() {
            Card(
               modifier = Modifier
                   .fillMaxWidth()
                   .height(200.dp),
                elevation = 2.dp
            ) {
               Image(painter = painterResource(id = Feature.image), contentDescription = "Item",
                   modifier = Modifier.fillMaxSize()
               )


            }
            Box(
                modifier = Modifier
                    .height(40.dp)
                    .fillMaxWidth()
                    .align(Alignment.End)
            ){
                Row(horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ){
                    Text(text = Feature.price,
                        style = MaterialTheme.typography.h4,
                        color = Color.Black,
                        fontSize = 20.sp
                    )
                    Image(painter = painterResource(id = R.drawable.ic_iconmonstr_shopping_cart_5), contentDescription = "shop",
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        }

    }

}


@Composable
fun AmazingSection(){
    Box() {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(20.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color(0xFF5870EB))
                .padding(horizontal = 15.dp, vertical = 20.dp)
                .fillMaxWidth()
        ) {
            Column(){
                Text(text = "Amazing",
                    style = MaterialTheme.typography.h3
                )
                Text(text = "Offers!",
                    style = MaterialTheme.typography.h3
                )
            }

            Image(painter = painterResource(id = R.drawable.ic_finance__e_commerce__startup__workflow___account__information__user__profile__data),
                contentDescription = "logo2",
                modifier = Modifier.size(140.dp)
            )
        }
    }
}

@Composable
fun Latest(features:List<feature>){
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Latest",
            style = MaterialTheme.typography.h2,
            modifier = Modifier.padding(10.dp)
        )
        LazyRow(
            contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 20.dp),
            modifier = Modifier.fillMaxHeight()
        ) {
            items(features.size) {
                LatestItems(Feature = features[it])
            }
        }
    }
}

@Composable
fun LatestItems(Feature:feature){
    Box(
        modifier = Modifier
            .height(240.dp)
            .width(150.dp)
            .padding(10.dp)
    ){
        Column() {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                elevation = 2.dp
            ) {
                Image(painter = painterResource(id = Feature.image), contentDescription = "Item",
                    modifier = Modifier.fillMaxSize()
                )


            }
            Box(
                modifier = Modifier
                    .height(40.dp)
                    .fillMaxWidth()
                    .align(Alignment.End)
            ){
                Row(horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ){
                    Text(text = Feature.price,
                        style = MaterialTheme.typography.h4,
                        color = Color.Black,
                        fontSize = 20.sp
                    )
                    Image(painter = painterResource(id = R.drawable.ic_iconmonstr_shopping_cart_5), contentDescription = "shop",
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        }

    }

}