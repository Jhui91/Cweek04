package com.example.cassignment02.uicomponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cassignment02.R

@Composable
fun ImageListL(viewModel: ImageViewModel, modifier: Modifier = Modifier) {

    Row (modifier = Modifier.padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center){
        Box {
            Image(
                painter = painterResource(id = R.drawable.body),
                contentDescription = "body"
            )
            if (viewModel.checked1) {
                Image(
                    painter = painterResource(id = R.drawable.arms),
                    contentDescription = "arms"
                )
            }
            if (viewModel.checked2) {
                Image(
                    painter = painterResource(id = R.drawable.eyebrows),
                    contentDescription = "eyebrows"
                )
            }
            if (viewModel.checked3) {
                Image(
                    painter = painterResource(id = R.drawable.glasses),
                    contentDescription = "glasses"
                )
            }
            if (viewModel.checked4) {
                Image(
                    painter = painterResource(id = R.drawable.mouth),
                    contentDescription = "mouth"
                )
            }
            if (viewModel.checked5) {
                Image(
                    painter = painterResource(id = R.drawable.nose),
                    contentDescription = "nose"
                )
            }
            if (viewModel.checked6) {
                Image(
                    painter = painterResource(id = R.drawable.ears),
                    contentDescription = "ears"
                )
            }
            if (viewModel.checked7) {
                Image(
                    painter = painterResource(id = R.drawable.eyes),
                    contentDescription = "eyes"
                )
            }
            if (viewModel.checked8) {
                Image(
                    painter = painterResource(id = R.drawable.hat),
                    contentDescription = "hat"
                )
            }
            if (viewModel.checked9) {
                Image(
                    painter = painterResource(id = R.drawable.mustache),
                    contentDescription = "mustache"
                )
            }
            if (viewModel.checked10) {
                Image(
                    painter = painterResource(id = R.drawable.shoes),
                    contentDescription = "shoes"
                )
            }
        }
        Row {
            Column(modifier = Modifier.padding(8.dp)) {
                ImageCheckBox(
                    text = "arms",
                    checked = viewModel.checked1,
                    onCheckedChange = { viewModel.checked1 = it }
                )
                ImageCheckBox(
                    text = "eyebrows",
                    checked = viewModel.checked2,
                    onCheckedChange = { viewModel.checked2 = it }
                )
                ImageCheckBox(
                    text = "glasses",
                    checked = viewModel.checked3,
                    onCheckedChange = { viewModel.checked3 = it }
                )
                ImageCheckBox(
                    text = "mouth",
                    checked = viewModel.checked4,
                    onCheckedChange = { viewModel.checked4 = it }
                )
                ImageCheckBox(
                    text = "nose",
                    checked = viewModel.checked5,
                    onCheckedChange = { viewModel.checked5 = it }
                )
            }
            Column(modifier = Modifier.padding(8.dp)) {
                ImageCheckBox(
                    text = "ears",
                    checked = viewModel.checked6,
                    onCheckedChange = { viewModel.checked6 = it }
                )
                ImageCheckBox(
                    text = "eyes",
                    checked = viewModel.checked7,
                    onCheckedChange = { viewModel.checked7 = it }
                )
                ImageCheckBox(
                    text = "hat",
                    checked = viewModel.checked8,
                    onCheckedChange = { viewModel.checked8 = it }
                )
                ImageCheckBox(
                    text = "mustache",
                    checked = viewModel.checked9,
                    onCheckedChange = { viewModel.checked9 = it }
                )
                ImageCheckBox(
                    text = "shoes",
                    checked = viewModel.checked10,
                    onCheckedChange = { viewModel.checked10 = it }
                )
            }
        }
    }
}

@Preview
@Composable
private fun ImageListLPreview() {
    val viewModel = ImageViewModel()
    ImageListL(viewModel)
}