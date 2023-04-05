package com.pskwiercz.orderservice.service;

import com.pskwiercz.orderservice.dto.OrderLineItemsDto;
import com.pskwiercz.orderservice.dto.OrderRequest;
import com.pskwiercz.orderservice.dto.OrderResponse;
import com.pskwiercz.orderservice.model.Order;
import com.pskwiercz.orderservice.model.OrderLineItems;
import com.pskwiercz.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItemsList = orderRequest.getOrderLineItemsDtoList()
                .stream()
                .map(this::mapToDto)
                .toList();

        order.setOrderLineItemsList(orderLineItemsList);

        orderRepository.save(order);
    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        return orderLineItems;
    }

    public List<OrderResponse> getAllOrders() {
        List<Order> products = orderRepository.findAll();
        return products.stream().map(this::mapToOrderResponse).toList();
    }
}
