package com.my.shashlik.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.shashlickcompose.R
import com.my.shashlik.presentation.mvi.MainScreenSideEffect
import com.my.shashlik.presentation.mvi.MainViewModel
import org.koin.androidx.compose.koinViewModel
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
fun MainScreen(mainViewModel: MainViewModel = koinViewModel()) {
    val context = LocalContext.current
    val snackbarHostState = remember { SnackbarHostState() }

    mainViewModel.collectSideEffect {
        when (it) {
            MainScreenSideEffect.ShowNoPeopleAmountErrorSnackBar -> snackbarHostState.showSnackbar(
                message = context.getString(R.string.toast_not_all_filled)
            )

            MainScreenSideEffect.ShowAmountErrorSnackBar -> snackbarHostState.showSnackbar(
                message = context.getString(R.string.toast_people)
            )
        }
    }

    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        }
    ) { paddingValues ->
        MainScreenUI(
            modifier = Modifier.padding(paddingValues)
        )
    }
}