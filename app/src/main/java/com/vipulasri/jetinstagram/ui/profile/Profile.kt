package com.vipulasri.jetinstagram.ui.profile

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row


import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.vipulasri.jetinstagram.R
import com.vipulasri.jetinstagram.data.PostsRepository
import com.vipulasri.jetinstagram.data.StoriesRepository
import com.vipulasri.jetinstagram.model.Post
import com.vipulasri.jetinstagram.model.Story
import com.vipulasri.jetinstagram.ui.components.icon
import com.vipulasri.jetinstagram.ui.home.StoryImage

@Composable
fun  ProfileScreen(modifier: Modifier = Modifier) {

    val posts by PostsRepository.posts
    val stories by StoriesRepository.observeStories()
    Scaffold(topBar = { Toolbar(stories) }){it

        Spacer(modifier = Modifier.padding(20.dp))

        Column {

            ProfileImageWithText(stories = stories)
            TextBelowImage(stories = stories)

                //shows the profile buttons
            ProfileButtons()
            ExpandableText()
            StoriesSection2(stories =stories)
            TabsDisplayed(posts)

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


        Text(if (stories.isNotEmpty()) stories.first().name else "No stories")
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
            Text(text = "1",  textAlign = TextAlign.Center)
            Text(text = "Posts")
        }

        Spacer(modifier = Modifier.width(20.dp))
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "54" , textAlign = TextAlign.Center)
            Text(text = "Followers")
        }
        Spacer(modifier = Modifier.width(20.dp))
        Column(horizontalAlignment = Alignment.CenterHorizontally){
            Text(text = "81",  textAlign = TextAlign.Center)
            Text(text = "Following")
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
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(8.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)

        ) {
            Text(text = "Edit Profile", color = Color.White)
        }

        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(8.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)


        ) {
            Text(text = "Promotion", color = Color.White)
        }

        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(8.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)

        ) {
            Text(text = "Email", color = Color.White)
        }
    }
}

@Composable
fun ExpandableText() {
    var showMore by remember { mutableStateOf(false) }
    val text = "Keep your favorite stories on your profile"

    // Creating a clickable modifier
    // that consists text
    Column(
        modifier = Modifier
            .animateContentSize(animationSpec = tween(100))
            .padding(16.dp)
    ) {
        // Use a Row to display "Show more" and the trailing icon
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Text "Show more" always visible
            Text(text = "Show more")

            // Add a trailing icon here
            Icon(
                imageVector = if (showMore) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                contentDescription = null, // Provide a meaningful description
                modifier = Modifier.clickable { showMore = !showMore }
            )
        }

        // Display the additional text when showMore is true
        if (showMore) {
            Text(text = text)
        }
    }
}@Composable
private fun StoriesSection2(stories: List<Story>) {
    Column{
        StoriesList(stories)
        Spacer(modifier = Modifier.height(10.dp))
    }
}

@Composable
private fun StoriesList(stories: List<Story>) {
    LazyRow {
        itemsIndexed(stories) { index, story ->

            if (index == 0) {
                Spacer(modifier = Modifier.width(6.dp))
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(vertical = 5.dp, horizontal = 6.dp)
            ) {
                StoryImage(imageUrl = story.image)
                Spacer(modifier = Modifier.height(5.dp))
                Text(story.name, style = MaterialTheme.typography.caption)
            }

            if (index == stories.size.minus(1)) {
                Spacer(modifier = Modifier.width(6.dp))
            }
        }
    }
}




@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TabsDisplayed(post: List<Post>) {
    var selectedTabIndex by remember { mutableStateOf(0) }
    val tabItems = listOf<TabItem>(
        TabItem(
            unselectedIcon = painterResource(id = R.drawable.ic_grid_on_outline),
            selectedIcon = painterResource(id = R.drawable.ic_grid_on_filled)
        ),
        TabItem(
            unselectedIcon = painterResource(id = R.drawable.ic_person_outline),
            selectedIcon = painterResource(id = R.drawable.ic_person_filled)
        )
    )

    // Create a custom modifier for the TabRow to set its background color
    val tabRowModifier = Modifier
        .background(Color.Black)
        .fillMaxWidth()

    TabRow(
        selectedTabIndex = selectedTabIndex,
        modifier = tabRowModifier,
        backgroundColor = Color.Transparent
    ) {
        tabItems.forEachIndexed { index, item ->
            Tab(
                selected = index == selectedTabIndex,
                onClick = { selectedTabIndex = index },
                // Use the Icon's tint parameter to set the content color to white
                icon = {
                    Icon(
                        painter = if (index == selectedTabIndex) {
                            item.selectedIcon
                        } else item.unselectedIcon,
                        contentDescription = null,
                        tint = Color.White // Set the content color to white
                    )
                }
            )
        }


    }



            when (selectedTabIndex) {
                0 -> {
                    // Content for Tab 1
                    LazyVerticalGrid(cells = GridCells.Fixed(3), content ={
                        items(post.size) { index ->
                            val postImage = post[index].image

                            Image(
                                painter = rememberImagePainter(data = postImage),
                                contentDescription = null,
                                modifier = Modifier
                                    .aspectRatio(1.35f)

                                    .fillMaxWidth()
                                    .fillMaxHeight()


                            )

                            Spacer(modifier = Modifier.heightIn(100.dp))
                        }
                    } )
                }

                1 -> {
                    // Content for Tab 2
                    Text("Content for Tab 2")
                }
            }
}






