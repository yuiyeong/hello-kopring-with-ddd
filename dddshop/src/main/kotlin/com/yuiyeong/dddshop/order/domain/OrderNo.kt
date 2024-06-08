package com.yuiyeong.dddshop.order.domain

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import java.io.Serializable

@Embeddable
class OrderNo(number: String) : Serializable {

    @Column(name = "order_number")
    var number: String = number
        private set

    override fun equals(other: Any?): Boolean {
        if (this === other) return true

        if (other !is OrderNo) return false
        if (number != other.number) return false

        return true
    }

    override fun hashCode(): Int {
        return number.hashCode()
    }

    companion object {
        fun of(number: String): OrderNo {
            return OrderNo(number)
        }
    }
}
