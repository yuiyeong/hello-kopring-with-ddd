package com.yuiyeong.dddshop.catalog.command.product

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import java.io.Serializable

@Embeddable
class ProductId(id: String) : Serializable {
    @Column(name = "product_id")
    var id: String = id
        private set


    override fun equals(other: Any?): Boolean {
        if (this === other) return true

        if (other !is ProductId) return false
        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

    companion object {
        fun of(id: String): ProductId {
            return ProductId(id)
        }
    }
}