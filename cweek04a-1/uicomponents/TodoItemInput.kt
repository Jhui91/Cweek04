package com.example.cweek04a.uicomponents

import android.content.ClipData
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cweek04a.Item
import com.example.cweek04a.TodoItemFactory

@Composable
fun TodoItemInput(todoList: MutableList<Item>, modifier: Modifier = Modifier) {
    var textFieldState by remember {
        mutableStateOf("")
    }
    Row(modifier = Modifier.fillMaxWidth()) {
        TextField(
            value = textFieldState,
            onValueChange = { content -> textFieldState = content },
            placeholder = { Text("할 일을 입력하세요") })
        Spacer(modifier = Modifier.width(4.dp))
        Button(onClick = {
            if (textfieldState.isNotBlank()) {
                // 할 일을 추가하는 로직
                val newItem = Item(content = textfieldState, time = "현재 시간") // 시간을 적절히 처리해야 할 수 있습니다.
                todoList.add(newItem)
                textfieldState = "" // 추가 후 텍스트 필드를 비움
            }
        }) {
            Text(text = "추가")
        }
    }
}

@Preview
@Composable
private fun TodoItemInputPreview() {
    TodoItemInput(todoList = mutableListOf())
}