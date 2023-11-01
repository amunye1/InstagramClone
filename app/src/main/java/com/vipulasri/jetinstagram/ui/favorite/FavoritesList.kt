package com.vipulasri.jetinstagram.ui.favorite

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Colors
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.vipulasri.jetinstagram.model.Story
import com.vipulasri.jetinstagram.ui.home.StoryImage


@Composable
 fun StoriesSection(stories: List<Story>) {
    Column {
        StoriesList(stories)
        Spacer(modifier = Modifier.height(10.dp))
    }
}

@Composable
private fun StoriesList(stories: List<Story>) {
    LazyColumn {
        itemsIndexed(stories) { index, story ->

            if (index == 0) {
                Spacer(modifier = Modifier.width(6.dp))
            }
            Row (modifier = Modifier.fillMaxWidth()
                ,
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween){
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(vertical = 5.dp, horizontal = 6.dp)

                ) {

                    StoryImage(imageUrl = story.image)
                    Spacer(modifier = Modifier.height(5.dp))


                }

                if (index == stories.size.minus(1)) {
                    Spacer(modifier = Modifier.width(6.dp))
                }
                Text(story.name, style = MaterialTheme.typography.caption)
                PurpleAddButton()
            }


        }
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PurpleAddButton() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp), // Adjust padding as needed
        shape = RoundedCornerShape(8.dp), // Adjust corner radius as needed
        color = MaterialTheme.colors.primary, // Set the background color to purple
        onClick = {
            // Handle button click action here
        }
    ) {

        Text(
            text = "Add",
            modifier = Modifier
                .padding(8.dp), // Adjust padding within the button as needed
            style = MaterialTheme.typography.button.copy(
                color = Color.White // Set the text color to white
            )
        )
    }
}

