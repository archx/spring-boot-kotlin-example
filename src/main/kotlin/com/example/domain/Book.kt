package com.example.domain

import com.example.common.extension.annotation.NoArgsConstructor
import java.util.*

/**
 * Book
 *
 * @author archx
 */
@NoArgsConstructor
data class Book(
    var id: Int?,
    var name: String,
    var publisher: String?,
    var publicationDate: Date?,
)