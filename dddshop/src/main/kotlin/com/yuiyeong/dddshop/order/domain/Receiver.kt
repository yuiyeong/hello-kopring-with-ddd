package com.yuiyeong.dddshop.order.domain

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
class Receiver(name: String, phone: String) {
    @Column(name = "receiver_name")
    var name: String = name
        private set

    @Column(name = "receiver_phone")
    var phone: String = phone
        private set
}
