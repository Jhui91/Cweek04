package com.example.cweek03a.model

data class Item(
    val content: String,
    val time: String,
    var status: TodoStatus = TodoStatus.PENDING
){
    override fun toString(): String {
        return "$content\t$time\t${if(status==TodoStatus.COMPLETED) "완료" else "미완료"}"
    }
}
