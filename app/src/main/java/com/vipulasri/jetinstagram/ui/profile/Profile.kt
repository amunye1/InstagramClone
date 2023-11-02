package com.vipulasri.jetinstagram.ui.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row


import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vipulasri.jetinstagram.R
import com.vipulasri.jetinstagram.data.StoriesRepository
import com.vipulasri.jetinstagram.model.Story
import com.vipulasri.jetinstagram.ui.components.icon
import com.vipulasri.jetinstagram.ui.favorite.SearchTextField
import com.vipulasri.jetinstagram.ui.favorite.StoriesSection
import com.vipulasri.jetinstagram.ui.home.StoryImage
import java.time.format.TextStyle

@Composable
fun  ProfileScreen(modifier: Modifier = Modifier) {


    val stories by StoriesRepository.observeStories()
    Scaffold(topBar = { Toolbar(stories) }){

        Spacer(modifier = Modifier.padding(20.dp))

        Column {
            ProfileImageWithText(stories = stories)
            TextBelowImage(stories = stories)
            Row(modifier= Modifier
                .padding(16.dp)
                ){

               ProfileButtons()
            }


        }

    }
}
@Composable
private fun Toolbar(stories: List<Story>) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .padding(horizontal = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier.padding(6.dp),
            contentAlignment = Alignment.Center
        ) {
            TextButtonExample(onClick = { /*TODO*/ }, stories = stories)

        }



        Icon(
            ImageVector.vectorResource(id = R.drawable.ic_filled_hamburger),
            modifier = Modifier.icon(),
            contentDescription = "A hamburger icon"
        )
    }
}

@Composable
fun TextButtonExample(onClick: () -> Unit, stories: List<Story>) {
    TextButton(
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White,
            contentColor = Color.Black
        )
    ) {


        Text(if (stories.isNotEmpty()) stories.first().name else "No stories", fontSize = 30.sp)
        Icon(

            painter= painterResource(id = R.drawable.ic_donward_facing_arrow),
            modifier = Modifier.icon(),
            contentDescription = "A downward arrow"
        )

    }
}
@Composable
fun ProfileImageWithText(stories: List<Story>){
    Row (
        modifier = Modifier.padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ){

        StoryImage(imageUrl = stories.first().image)
        Spacer(modifier = Modifier.width(24.dp))
        Column(horizontalAlignment = Alignment.CenterHorizontally){
            Text(text = "1", fontSize = 20.sp, textAlign = TextAlign.Center)
            Text(text = "Posts", fontSize = 20.sp)
        }
        Spacer(modifier = Modifier.width(20.dp))
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "54" , fontSize = 20.sp, textAlign = TextAlign.Center)
            Text(text = "Followers", fontSize = 20.sp)
        }
        Spacer(modifier = Modifier.width(20.dp))
        Column(horizontalAlignment = Alignment.CenterHorizontally){
            Text(text = "81", fontSize = 20.sp, textAlign = TextAlign.Center)
            Text(text = "Following", fontSize = 20.sp)
        }

        
        
    }
}

@Composable
fun TextBelowImage(stories: List<Story>){
    Column (modifier = Modifier
        .padding(16.dp)
        .height(56.dp)){
        Text(text = "${stories.first().name}  placeholder")
        Text(text = "Personal Blog", fontStyle = FontStyle.Italic , color = Color.Gray )
    }

}

@Composable
fun ProfileButtons(){

    Row(modifier= Modifier
        .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Button(
            onClick = { },
            modifier = Modifier.
            fillMaxWidth().weight(1f).padding(8.dp)


        ) {
            Text(text = "Edit Profile")
        }



        Button(
            onClick = { },
            modifier = Modifier.
            fillMaxWidth().weight(1f).padding(8.dp)


        ) {
            Text(text = "Promotion")
        }


        Button(
            onClick = { },
            modifier = Modifier.
            fillMaxWidth().weight(1f).padding(8.dp)


        ) {
            Text(text = "Email")
        }

    }



}

