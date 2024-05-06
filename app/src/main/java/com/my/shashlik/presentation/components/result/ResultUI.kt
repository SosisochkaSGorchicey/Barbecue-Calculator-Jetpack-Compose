package com.my.shashlik.presentation.components.result

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.shashlickcompose.R
import com.my.shashlik.presentation.mvi.MainViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun ResultUI(
    mainViewModel: MainViewModel = koinViewModel()
) {
    val state by mainViewModel.container.stateFlow.collectAsState()

    Row(
        modifier = Modifier
            .padding(top = 20.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .clip(shape = RoundedCornerShape(24.dp))
                .background(MaterialTheme.colorScheme.onBackground)
                .padding(vertical = 8.dp, horizontal = 12.dp),
            text = state.result?.let {
                stringResource(id = R.string.result, it)
            } ?: stringResource(id = R.string.result_empty),
            color = MaterialTheme.colorScheme.secondaryContainer,
            style = MaterialTheme.typography.titleMedium
        )

        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.secondaryContainer,
            ),
            shape = RoundedCornerShape(24.dp),
            onClick = {

            },
        ) {
            Text(
                text = stringResource(R.string.count),
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}