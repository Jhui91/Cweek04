package com.example.cassignment02.uicomponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ImageCheckBox(
    text: String,
    checked: Boolean,
    modifier: Modifier = Modifier,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = { checked -> onCheckedChange(checked) },
            modifier = modifier
        )
        Text(text = text)
    }

}

@Preview
@Composable
private fun ImageCheckBoxPreview() {
    ImageCheckBox("arm", true) {}
}