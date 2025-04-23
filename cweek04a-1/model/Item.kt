package com.example.cweek04a

import com.example.cweek04a.TodoStatus

data class Item(
    val content: String,
    val time: String,
    var status: TodoStatus = TodoStatus.PENDING
)
