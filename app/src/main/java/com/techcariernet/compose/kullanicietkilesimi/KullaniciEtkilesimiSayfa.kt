package com.techcariernet.compose.kullanicietkilesimi

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KullaniciEtkilesimiSayfa() {

    val scope = rememberCoroutineScope()
    val snackBarHostState = remember {
        SnackbarHostState()
    }


    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = "KullaniciEtkilesimi") })
    },
        snackbarHost = { SnackbarHost(hostState = snackBarHostState){
            Snackbar(snackbarData = it, containerColor = Color.White, contentColor = Color.Blue, actionColor = Color.Red)
        }
            
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = { scope.launch {
                val sb=snackBarHostState.showSnackbar("Silmek istermisiniz","Evet")
                if(sb==SnackbarResult.ActionPerformed){
                    snackBarHostState.showSnackbar("Silindi")
                }
                } })
            { Text(text = "Snackbar") }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Alert")
            }
        }
    }
}