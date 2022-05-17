package com.example.herosapp.presentation.common

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.LazyPagingItems
import coil.compose.rememberAsyncImagePainter
import com.example.herosapp.R
import com.example.herosapp.domain.model.Hero
import com.example.herosapp.navigation.Screen
import com.example.herosapp.presentation.components.RatingWidget
import com.example.herosapp.ui.theme.*
import com.example.herosapp.util.Constants.BASE_URL

@Composable
fun ListContent(
    navController: NavHostController,
    heroes: LazyPagingItems<Hero>,
) {

}

@Composable
fun HeroItem(
    hero: Hero,
    navController: NavHostController,
) {
    val painter = rememberAsyncImagePainter(
        model = "$BASE_URL${hero.image}",
        placeholder = painterResource(R.drawable.ic_placeholder),
        error = painterResource(R.drawable.ic_placeholder))

    Box(
        modifier = Modifier
            .height(HERO_ITEM_HEIGHT)
            .clickable {
                navController.navigate(Screen.Details.passHeroId(heroId = hero.id))
            },
        contentAlignment = Alignment.BottomStart) {
        Surface(shape = Shapes.large) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painter,
                contentDescription = stringResource(R.string.hero_image),
                contentScale = ContentScale.Crop)
        }
        Surface(
            modifier = Modifier
                .fillMaxHeight(0.4f)
                .fillMaxWidth(),
            color = Color.Black.copy(ContentAlpha.medium),
            shape = RoundedCornerShape(
                bottomStart = LARGE_PADDING,
                bottomEnd = LARGE_PADDING
            )
        ) {
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(all = MEDIUM_PADDING)) {
                Text(
                    text = hero.name,
                    color = MaterialTheme.colors.topAppBarContentColor,
                    fontSize = MaterialTheme.typography.h5.fontSize,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = hero.about,
                    color = Color.White.copy(alpha = ContentAlpha.medium),
                    fontSize = MaterialTheme.typography.subtitle1.fontSize,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
                Row(
                    modifier = Modifier.padding(top = SMALL_PADDING),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    RatingWidget(modifier = Modifier.padding(end = SMALL_PADDING),
                        rating = hero.rating)
                    Text(text = "(${hero.rating})",
                        textAlign = TextAlign.Center,
                        color = Color.White.copy(alpha = ContentAlpha.medium))

                }
            }
        }


    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun HeroItemPrev() {
    HeroItem(hero = Hero(
        id = 1,
        name = "Hello",
        image = "",
        about = " DSAPDW DASDQWD ASDQAWD ",
        rating = 4.5,
        power = 100,
        month = "",
        day = "",
        family = listOf(),
        abilities = listOf(),
        natureTypes = listOf()
    ), navController = rememberNavController())
}