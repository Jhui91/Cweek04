package com.example.week03.lab.model

data class Item(
    val content: String,
    val time: String,
    var status: TodoStatus = TodoStatus.PENDING
)