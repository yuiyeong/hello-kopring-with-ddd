package com.yuiyeong.dddshop.common

import com.yuiyeong.dddshop.order.domain.Money
import jakarta.persistence.AttributeConverter

class MoneyConverter : AttributeConverter<Money, Int> {
    override fun convertToDatabaseColumn(money: Money?): Int {
        return money?.value ?: 0
    }

    override fun convertToEntityAttribute(value: Int?): Money {
        return Money(value ?: 0)
    }
}