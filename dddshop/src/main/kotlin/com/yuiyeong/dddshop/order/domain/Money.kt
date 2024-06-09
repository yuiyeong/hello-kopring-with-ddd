package com.yuiyeong.dddshop.order.domain

data class Money(val value: Int) {
    fun multiply(multiplier: Int): Money {
        return Money(value * multiplier)
    }
}
