package com.example.mapper

import com.example.domain.Book
import org.apache.ibatis.annotations.Mapper
import org.springframework.stereotype.Repository

/**
 * BookMapper
 *
 * @author archx
 */
@Mapper
@Repository
interface BookMapper {

    fun findById(id: Int) : Book?
}