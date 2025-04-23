package com.example.cweek03a

import com.example.cweek03a.model.Item
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class TodoService(val todoList:MutableList<Item>) {
    fun addContent(content:String){
        val currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM-dd HH:mm"))
        todoList.add(Item(content, currentTime))
    }

    fun listTodo(){
        if(todoList.isEmpty()){
            println("등록된 일정이 없습니다.")
        }else{
            println("전체 메모:")
            todoList.forEachIndexed { index, item ->
                println("$index: $item")
            }
        }
    }
}