package com.vipulasri.jetinstagram.ui.favorite

import androidx.compose.compiler.plugins.kotlin.ComposeFqNames.remember
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vipulasri.jetinstagram.R
import com.vipulasri.jetinstagram.ui.components.icon

@ExperimentalFoundationApi
@Composable
fun FavoriteScreen(modifier: Modifier = Modifier) {



    Scaffold(
        topBar = { Toolbar() }){

        Spacer(modifier = Modifier.padding(20.dp))
        Text(text = stringResource(R.string.favourite_text)
            , fontSize = 16.sp,
            modifier = Modifier.padding(16.dp)
            )

    }
}


@Composable
private fun Toolbar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier.padding(6.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                ImageVector.vectorResource(id = R.drawable.ic_filled_x),
                contentDescription = ""
            )

        }

        Text(text = stringResource(id = R.string.favourtie),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
            //modifier = Modifier.align(Alignment.Center)
        )

        Icon(
            ImageVector.vectorResource(id = R.drawable.ic_filled_plus),
            modifier = Modifier.icon(),
            contentDescription = ""
        )
    }
}

@Composable
fun SearchTextField() {
    val searchText = remember { mutableStateOf("") }

    TextField(
        value = searchText.value,
        onValueChange = { newValue ->
            searchText.value = newValue
        }
    )
}