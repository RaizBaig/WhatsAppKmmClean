package com.example.whatsappkmmclean.android
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.whatsappkmmclean.android.presentation.ui.*
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Preview
@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun MainScreen() {
    val screens = listOf(Screen.Chats, Screen.Updates, Screen.Communities, Screen.Calls)
    val pagerState = rememberPagerState { screens.size }
    var selectedIndex by remember { mutableStateOf(0) }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(pagerState.currentPage) {
        selectedIndex = pagerState.currentPage
    }

    val title = when (screens[selectedIndex].route) {
        Screen.Chats.route -> stringResource(R.string.whatsapp)
        Screen.Updates.route -> stringResource(R.string.updates)
        Screen.Communities.route -> stringResource(R.string.communities)
        Screen.Calls.route -> stringResource(R.string.calls)
        else -> "App"
    }

    Scaffold(
        topBar = { TopAppBar(title = { Text(title) }) },
        bottomBar = {
            BottomNavigationBar(
                selectedIndex = selectedIndex,
                onTabSelected = { index ->
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                }
            )
        }
    ) { paddingValues ->
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.padding(paddingValues)
        ) { page ->
            when (screens[page].route) {
                Screen.Chats.route -> ChatScreen()
                Screen.Updates.route -> UpdatesScreen()
                Screen.Communities.route -> CommunitiesScreen()
                Screen.Calls.route -> CallsScreen()
            }
        }
    }
}
