package com.yuiyeong.dddshop.order.application

import com.yuiyeong.dddshop.order.domain.OrderNo
import com.yuiyeong.dddshop.order.infastructure.OrderRepository
import jakarta.transaction.Transactional
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class CancelOrderService(private val orderRepository: OrderRepository) {

    @Transactional
    fun cancel(orderNo: OrderNo) {
        val order = orderRepository.findByIdOrNull(orderNo.number) ?: throw IllegalArgumentException("No order")
        order.cancel()
    }
}