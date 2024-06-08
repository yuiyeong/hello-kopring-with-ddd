package com.yuiyeong.dddshop.order.domain

import jakarta.persistence.*

@Embeddable
class ShippingInfo(address: Address, message: String, receiver: Receiver) {

    @Embedded
    @AttributeOverrides(
        value = [
            AttributeOverride(name = "zipCode", column = Column(name = "shipping_zip_code")),
            AttributeOverride(name = "address1", column = Column(name = "shipping_addr1")),
            AttributeOverride(name = "address2", column = Column(name = "shipping_addr2"))
        ]
    )
    var address: Address = address
        private set

    @Column(name = "shipping_message")
    var message: String = message
        private set

    @Embedded
    var receiver: Receiver = receiver
        private set
}
