package com.yuiyeong.dddshop.member

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import java.io.Serializable
import java.util.*

@Embeddable
class MemberId(id: String) : Serializable {
    @Column(name = "member_id")
    var id: String = id
        private set

    override fun equals(other: Any?): Boolean {
        if (this === other) return true

        if (other !is MemberId) return false
        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return Objects.hash(id)
    }

    companion object {
        fun of(id: String): MemberId {
            return MemberId(id)
        }
    }
}