package com.yuiyeong.dddshop.order.domain

import jakarta.persistence.Embeddable

@Embeddable
data class Address(
    val zipCode: String,
    val address1: String,
    val address2: String
) {}
