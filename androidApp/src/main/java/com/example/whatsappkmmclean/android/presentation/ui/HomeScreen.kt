package com.example.whatsappkmmclean.android.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsappkmmclean.android.R
import com.example.whatsappkmmclean.domain.model.ChatData

@Composable
fun ChatScreen() {
    val chatList = listOf(
        ChatData("Alice", "Hey! How are you?", null , 0),
        ChatData("Bob", "Let's catch up later!", null , 0),  // No image, uses default
        ChatData("Charlie", "Meeting at 5 PM", null , 0),
        ChatData("David", "Check this out!", null , 0) , // No image, uses default
        ChatData("Alice", "Hey! How are you?", null , 0),
        ChatData("Bob", "Let's catch up later!", null , 0),  // No image, uses default
        ChatData("Charlie", "Meeting at 5 PM", null , 0),
        ChatData("David", "Check this out!", null , 0) , // No image, uses default
        ChatData("Alice", "Hey! How are you?", null , 0),
        ChatData("Bob", "Let's catch up later!", null , 0),  // No image, uses default
        ChatData("Charlie", "Meeting at 5 PM", null , 0),
        ChatData("David", "Check this out!", null , 0)  // No image, uses default
    )

    LazyColumn() {
        items(chatList){chat ->
            ChatList(chat)
        }
    }
}

@Composable
fun ChatList(chatData: ChatData){
  Row(verticalAlignment = Alignment.CenterVertically , modifier = Modifier.padding(8.dp)) {
      Image(
          painterResource(chatData.dp ?: R.drawable.baseline_assignment_ind_24),
          contentScale = ContentScale.Crop,
          contentDescription = "Profile Image",
          modifier = Modifier.
          size(50.dp)
              .clip(CircleShape)
              .background(Color.Gray)
              .border(2.dp , Color.LightGray, shape = CircleShape)
      )
      Column(modifier = Modifier.padding(8.dp)) {
          Text(text = chatData.name, fontWeight = FontWeight.Bold, fontSize = 16.sp)
          Text(text = chatData.message ?: "", fontSize = 14.sp, color = Color.Gray)
      }
  }
}
@Composable
fun UpdatesScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Updates Screen", fontSize = 24.sp)
    }
}

@Composable
fun CommunitiesScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Status Screen", fontSize = 24.sp)
    }
}


@Composable
fun CallsScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Settings Screen", fontSize = 24.sp)
    }
}
