package com.example.cweek04a.uicomponents

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.cweek04a.R

@Composable
fun TodoListTitle(modifier: Modifier = Modifier) {
    Column {
        Text(
            text = stringResource(id = R.string.todoList_Title),
            fontSize = 24.sp,
            fontWeight = FontWeight.ExtraBold,
            modifier = modifier
        )
        Text(
            text = "201910457 김진희",
            fontSize = 12.sp,
            modifier = modifier
        )
    }
}

@Preview
@Composable
private fun TodoListTitlePreview() {
    TodoListTitle()
}