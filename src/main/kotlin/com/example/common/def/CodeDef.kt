package com.example.common.def

/**
 * CodeDef
 *
 * @author archx
 */
enum class CodeDef(override val code: Int, override val message: String):MessageCode {
    Success(0, "ok"),
    Failure(1, "fail"),
}