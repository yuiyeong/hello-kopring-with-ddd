package com.yuiyeong.dddshop.order.domain

import com.yuiyeong.dddshop.catalog.command.product.ProductId
import jakarta.persistence.*

@Entity
class OrderLine(productId: ProductId, price: Money, quantity: Int) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
        private set

    @Embedded
    var productId: ProductId = productId
        private set

    var price: Money = price
        private set

    var quantity: Int = quantity
        private set

    var amounts: Money = Money()
        private set

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_number")
    lateinit var order: Order
        private set
}
