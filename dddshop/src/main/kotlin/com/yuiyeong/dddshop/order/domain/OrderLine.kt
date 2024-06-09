package com.yuiyeong.dddshop.order.domain

import com.yuiyeong.dddshop.catalog.command.product.ProductId
import com.yuiyeong.dddshop.common.MoneyConverter
import jakarta.persistence.*

@Embeddable
class OrderLine(productId: ProductId, price: Money, quantity: Int) {

    @Embedded
    var productId: ProductId = productId
        private set

    @Convert(converter = MoneyConverter::class)
    var price: Money = price
        private set

    var quantity: Int = quantity
        private set

    @Convert(converter = MoneyConverter::class)
    var amounts: Money
        private set

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_number")
    lateinit var order: Order
        private set

    init {
        amounts = price.multiply(quantity)
    }
}
