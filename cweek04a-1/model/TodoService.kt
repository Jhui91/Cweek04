package com.example.cweek04a.model

import com.example.cweek04a.Item
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class TodoService(val todoList: MutableList<Item>) {
    fun addContent(content: String) {
        val currentTime =
            LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM-dd HH:mm"))
        todoList.add(Item(content, currentTime))
    }
}
