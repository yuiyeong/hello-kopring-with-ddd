package com.yuiyeong.dddshop.order.domain

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "purchase_order")
class Order(
    orderNo: OrderNo,
    orderer: Orderer,
    orderLines: MutableList<OrderLine>,
    shippingInfo: ShippingInfo,
    state: OrderState
) {
    @EmbeddedId
    var number: OrderNo = orderNo
        private set

    @Embedded
    var orderer: Orderer = orderer
        private set

    @OneToMany(mappedBy = "order", cascade = [CascadeType.ALL])
    var orderLines: MutableList<OrderLine> = orderLines
        private set

    @Embedded
    var shippingInfo: ShippingInfo = shippingInfo
        private set

    @Enumerated(EnumType.STRING)
    var state: OrderState = state
        private set

    var totalAmounts: Money = Money()
        private set

    var orderDate: LocalDateTime = LocalDateTime.now()
        private set

    @Version
    private var version: Long = 0
}