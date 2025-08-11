package com.nutrisport.auth.component

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import ContentWithMessageBar
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.nutrisport.shared.Alpha
import com.nutrisport.shared.BebasNeueFont
import com.nutrisport.shared.FontSize
import com.nutrisport.shared.Gray
import com.nutrisport.shared.Orange
import org.jetbrains.compose.ui.tooling.preview.Preview
import rememberMessageBarState

@Preview()
@Composable
fun AuthScreen() {
    val messageBarState = rememberMessageBarState()

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { paddingValues ->
        ContentWithMessageBar(
            messageBarState = messageBarState,
            errorMaxLines = 2
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
               Column(
                   modifier = Modifier.weight(1f),
                   verticalArrangement = Arrangement.Center,
                   horizontalAlignment = Alignment.CenterHorizontally
               ){
                   Text(
                       modifier = Modifier.fillMaxWidth(),
                       text = "NUTRISPORT",
                       textAlign = TextAlign.Center,
                       fontFamily = BebasNeueFont(),
                       fontSize = FontSize.EXTRA_LARGE,
                       color = Orange
                   )

                   Text(
                       modifier = Modifier
                           .fillMaxWidth()
                           .alpha(Alpha.HALF),
                       text = "Sign in to continue",
                       textAlign = TextAlign.Center,
                       fontSize = FontSize.EXTRA_REGULAR,
                       color = Gray
                   )
               }

                GoogleButton(
                    loading = false,
                    onClick = {}
                )
            }
        }
    }
}

