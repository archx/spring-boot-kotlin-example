package com.example.common.def

/**
 * MessageCodeResult
 *
 * @author archx
 */
data class MessageCodeResult<T>(
    val code: Int = 0,
    val message: String = "ok",
    val result: T?,
    val timestamp: Long
) {
    companion object {

        fun <T> ok(): MessageCodeResult<T> {
            return build(CodeDef.Success, null)
        }

        fun <T> ok(data: T?): MessageCodeResult<T> {
            return build(CodeDef.Success, data)
        }

        fun <T> fail(): MessageCodeResult<T> {
            return build(CodeDef.Failure, null)
        }

        fun <T> fail(message: String): MessageCodeResult<T> {
            return MessageCodeResult(1, message, null, timestamp())
        }

        fun <T> fail(mc: MessageCode): MessageCodeResult<T> {
            return build(mc, null)
        }

        fun <T> fail(code: Int, message: String): MessageCodeResult<T> {
            return MessageCodeResult(code, message, null, timestamp())
        }

        private fun <T> build(mc: MessageCode, data: T?): MessageCodeResult<T> {
            return MessageCodeResult(mc.code, mc.message, data, timestamp())
        }

        private fun timestamp(): Long {
            return java.util.Calendar.getInstance().timeInMillis
        }
    }
}