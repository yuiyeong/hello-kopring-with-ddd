package com.yuiyeong.dddshop.order.domain

import com.yuiyeong.dddshop.member.MemberId
import jakarta.persistence.AttributeOverride
import jakarta.persistence.AttributeOverrides
import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
class Orderer(memberId: MemberId, name: String) {
    @AttributeOverrides(AttributeOverride(name = "id", column = Column(name = "orderer_id")))
    var memberId: MemberId = memberId
        private set

    @Column(name = "orderer_name")
    var name: String = name
        private set

    override fun equals(other: Any?): Boolean {
        if (this === other) return true

        if (other !is Orderer) return false

        return memberId == other.memberId && name == other.name
    }


    override fun hashCode(): Int {
        return arrayOf(memberId, name).contentHashCode()
    }
}
