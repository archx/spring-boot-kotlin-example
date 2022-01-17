package com.example.common.exception

import com.example.common.def.MessageCode
import com.example.common.extension.annotation.AllOpen

@AllOpen
class MessageCodeException(override val code: Int, override val message: String) : RuntimeException(message), MessageCode {
    constructor(mc: MessageCode): this(mc.code, mc.message)
}

@AllOpen
class BizException(mc: MessageCode): MessageCodeException(mc)