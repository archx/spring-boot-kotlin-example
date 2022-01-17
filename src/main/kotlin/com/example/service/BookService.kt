package com.example.service

import com.example.domain.Book
import com.example.mapper.BookMapper
import org.springframework.stereotype.Service

/**
 * BookService
 *
 * @author archx
 */
interface BookService {
    fun findById(id: Int) : Book?
}

@Service
class BookServiceImpl(private val bookMapper: BookMapper): BookService {
    override fun findById(id: Int): Book? = bookMapper.findById(id)
}