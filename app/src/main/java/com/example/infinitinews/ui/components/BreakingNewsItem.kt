package com.example.infinitinews.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.infinitinews.data.model.Article

@Composable
fun BreakingNewsItem(article: Article, onItemClick: (Article) -> Unit) {
    Card(modifier = Modifier
        .height(200.dp)
        .width(250.dp)
        .padding(all = 10.dp).clickable {
            onItemClick.invoke(article)
        }) {
        Box(contentAlignment = Alignment.BottomCenter) {
            AsyncImage(
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds,
                model = article.urlToImage, contentDescription = null
            )
            Text(
                text = article.title,
                style = TextStyle(color = Color.White),
                modifier = Modifier.padding(all = 5.dp,)
            )
        }
    }
}