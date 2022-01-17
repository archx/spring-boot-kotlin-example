package com.example.controller

import com.example.common.def.MessageCodeResult
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * IndexController
 *
 * @author archx
 */
@RestController
class IndexController {

    @RequestMapping("/", produces = ["application/json"])
    fun index() = MessageCodeResult.ok<Any>()
}