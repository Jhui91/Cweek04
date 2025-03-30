package com.example.cweek04a.uicomponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cweek04a.model.Item
import com.example.cweek04a.model.TodoItemFactory
import com.example.cweek04a.model.TodoStatus

@Composable
fun TodoList(
    todoList: MutableList<Item>,
    showPendingOnly: Boolean,
    modifier: Modifier = Modifier
) {

    val scrollStatus = rememberScrollState()
    val filteredList = if (showPendingOnly) {
        todoList.filter { it.status == TodoStatus.PENDING }
    } else {
        todoList
    }
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp)
            .verticalScroll(state = scrollStatus)
    ) {
        filteredList.forEachIndexed { index, item ->
            Card(modifier = Modifier.fillMaxWidth()) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(15.dp)
                ) {
                    TodoCheckBox(checked = item.status == TodoStatus.COMPLETED) { checked ->
                        todoList[index] = item.copy(
                            status = if (checked) TodoStatus.COMPLETED
                            else TodoStatus.PENDING
                        )
                    }
                    TodoItem(item = item)
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}


@Preview
@Composable
private fun TodoListPreview() {
    val todoList = TodoItemFactory.makeTodoList()
    val showPendingOnly = true
    TodoList(todoList = todoList, showPendingOnly = showPendingOnly)
}