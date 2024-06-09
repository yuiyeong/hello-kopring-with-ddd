package com.yuiyeong.dddshop.order.domain

import com.yuiyeong.dddshop.common.MoneyConverter
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

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "order_line", joinColumns = [JoinColumn(name = "order_number")])
    @OrderColumn(name = "line_idx")
    var orderLines: MutableList<OrderLine> = orderLines
        private set

    @Embedded
    var shippingInfo: ShippingInfo = shippingInfo
        private set

    @Enumerated(EnumType.STRING)
    var state: OrderState = state
        private set

    @Convert(converter = MoneyConverter::class)
    var totalAmounts: Money = Money(0)
        private set

    var orderDate: LocalDateTime = LocalDateTime.now()
        private set

    @Version
    private var version: Long = 0
}