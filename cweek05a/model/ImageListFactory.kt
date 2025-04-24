package com.example.cweek05a.model

import androidx.compose.runtime.mutableStateListOf
import com.example.cweek05a.R

object ImageListFactory {
    fun makeImageList() = mutableStateListOf(
        ImageData(
            image = ImageUri.ResImage(R.drawable.img1),
            likes = 50
        ),
        ImageData(
            image = ImageUri.ResImage(R.drawable.img2),
            buttonType = ButtonType.EMOJI,
            likes = 50,
            dislikes = 5
        ),
        ImageData(
            image = ImageUri.ResImage(R.drawable.img3),
            buttonType = ButtonType.ICON,
            likes = 100
        )
    )
}