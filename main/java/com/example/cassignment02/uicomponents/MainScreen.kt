package com.example.cassignment02.uicomponents

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val viewModel: ImageViewModel = viewModel()
    val orientation = LocalConfiguration.current.orientation
    if (orientation == Configuration.ORIENTATION_PORTRAIT) {
        ImageList(viewModel)
    } else {
        ImageListL(viewModel)
    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen()
}