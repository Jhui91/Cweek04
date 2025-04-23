package com.example.cweek03a

import com.example.cweek03a.model.TodoListFactory
import com.example.cweek03a.model.TodoStatus

fun main() {
    var todoService = TodoService(TodoListFactory.makeTodoList())
    val menuList = listOf<String>(
        "메모 등록", "메모 완료 체크", "메모 검색", "메모 전체 리스트 보기", "종료"
    )
    do {
        println("\n201910457 김진희")
        println("===== TodoList 메뉴 =====")
        menuList.forEachIndexed { index, item ->
            println("${index + 1}. $item")
        }
        print("메뉴 선택: ")
        val menu = readlnOrNull()?.toIntOrNull() ?: 0
        when (menu) {
            1 -> {
                print("등록할 메모를 입력하세요: ")
                val newContent = readln()
                todoService.addContent(newContent)
                println("메모 등록 처리됨: ${todoService.todoList.last()}")
            }

            2 -> {
                todoService.listTodo()
                print("완료 처리할 메모의 인덱스를 입력하세요: ")
                val index: Int = readlnOrNull()?.toIntOrNull() ?: -1
                if (index in todoService.todoList.indices) {
                    todoService.todoList[index].status = TodoStatus.COMPLETED
                    println("메모 완료 처리됨: ${todoService.todoList[index]}")
                } else println("완료 처리할 메모의 인덱스가 없습니다.")
            }

            3 -> {
                print("검색할 키워드를 입력하세요: ")
                val keyword = readln()
                val filteredList = todoService.todoList.filter {
                    it.content.contains(keyword)
                }
                filteredList.forEachIndexed { index, item ->
                    println("$index: $item")
                }
            }

            4 -> todoService.listTodo()
        }
    } while (menu != 5)
}
