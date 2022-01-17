package com.example.controller

import com.example.common.def.MessageCodeResult
import com.example.domain.Book
import com.example.service.BookService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * BookController
 *
 * @author archx
 */
@RestController
@RequestMapping("/book")
class BookController(private val bookService: BookService) {

    @GetMapping("/{id}")
    fun readById(@PathVariable("id") id: Int) : MessageCodeResult<Book> {
        return MessageCodeResult.ok(bookService.findById(id))
    }
}