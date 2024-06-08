package com.yuiyeong.dddshop.order.domain

import jakarta.persistence.Embeddable

@Embeddable
class Address(zipCode: String, address1: String, address2: String) {
    var zipCode: String = zipCode
        private set

    var address1: String = address1
        private set

    var address2: String = address2
        private set
}