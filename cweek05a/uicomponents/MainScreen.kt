package com.example.cweek05a.uicomponents

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.cweek05a.model.ImageData
import com.example.cweek05a.model.ImageUri
import com.example.cweek05a.R
import com.example.cweek05a.model.ButtonType

@Composable
fun MainScreen(modifier: Modifier = Modifier) {

    val img1State = rememberSaveable(stateSaver = ImageData.imageSaver) {
        mutableStateOf(
            ImageData(
                image = ImageUri.ResImage(R.drawable.img1),
                likes = 50
            )
        )
    }

    val img2State = rememberSaveable(stateSaver = ImageData.imageSaver) {
        mutableStateOf(
            ImageData(
                image = ImageUri.ResImage(R.drawable.img2),
                buttonType = ButtonType.EMOJI,
                likes = 50,
                dislikes = 10
            )
        )
    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen()
}