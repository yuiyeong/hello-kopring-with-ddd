package com.yuiyeong.dddshop.order.infastructure

import com.yuiyeong.dddshop.order.domain.Order
import com.yuiyeong.dddshop.order.domain.OrderNo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*
import java.util.concurrent.ThreadLocalRandom

@Repository
interface OrderRepository : JpaRepository<Order, String> {
    fun nextOrderNo(): OrderNo {
        val randomNo = ThreadLocalRandom.current().nextInt(900000) + 100000
        val number = String.format("%tY%<tm%<td%<tH-%d", Date(), randomNo)
        return OrderNo(number)
    }
}