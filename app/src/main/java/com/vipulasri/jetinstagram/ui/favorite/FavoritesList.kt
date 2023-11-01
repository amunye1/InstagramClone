package com.vipulasri.jetinstagram.ui.favorite

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.text.style.TextAlign
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
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 5.dp, horizontal = 6.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Left side of the Row: Image and Text
                Row(verticalAlignment = Alignment.CenterVertically) {
                    StoryImage(imageUrl = story.image)
                    Spacer(modifier = Modifier.width(10.dp)) // Padding between image and text
                    Column {
                        Text(
                            text = story.name,
                            style = MaterialTheme.typography.caption,
                        )
                        Text(
                            text = "${story.name} placeholder",
                            style = MaterialTheme.typography.caption,
                        )
                    }
                    
                }

                // Right side of the Row: PurpleAddButton

                    PurpleAddButton()

            }

            // Space after each item, except the last one
            if (index < stories.size - 1) {
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PurpleAddButton() {
    Surface(
        modifier = Modifier
            .size(120.dp, 70.dp)
            .padding(16.dp)
        , // Adjust padding as needed
        shape = RoundedCornerShape(8.dp), // Adjust corner radius as needed
        color = MaterialTheme.colors.primary, // Set the background color to purple
        onClick = {
            // Handle button click action here
        },


    ) {

        Text(
            text = "Add",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(8.dp), // Adjust padding within the button as needed

            style = MaterialTheme.typography.button.copy(
                color = Color.White // Set the text color to white
            )
        )
    }
}

