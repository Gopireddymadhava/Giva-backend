package com.exception.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exception.dto.OrderItemDto;
import com.exception.dto.ProductDto;
import com.exception.entities.CartItem;
import com.exception.entities.Order;
import com.exception.entities.OrderItem;
import com.exception.entities.Product;
import com.exception.repositories.OrderItemRepo;
import com.exception.repositories.OrderRepo;
import com.exception.repositories.ProductRepo;

@Service
public class OrderItemService {
	
	@Autowired
    private OrderItemRepo orderItemRepository;
	@Autowired
	private CartItemService cartService;
	@Autowired
	private OrderRepo orderRepository;
	
	@Autowired
	private ProductRepo productRepository;

//Method used to get list of Orders based on particular userId
	public List<OrderItemDto> getOrders(Long user_id) {
	    List<Order> orders = orderRepository.getOrder(user_id);
	    return orders.stream()
                .flatMap(order -> orderItemRepository.getOrderItemd(order.getOrder_id()).stream()
                        .map(orderItem -> {
                            Product product = productRepository.getProductById(orderItem.getProduct().getId());

                            OrderItemDto response = new OrderItemDto();
                            response.setId(orderItem.getId());
                            response.setOrderId(orderItem.getId());
                            response.setProductId(orderItem.getProduct().getId());
                            response.setName(product.getName());
                            response.setQuantity(orderItem.getQuantity());
                            response.setImageUrl(product.getImageUrl());

                            return response;
                        })
                )
                .collect(Collectors.toList());
    
	}
	

	//Method used to get List of Orders by Order Id
	public List<OrderItemDto> getOrdersByOrderId(Long order_id) {
	    List<OrderItem> orderItems = orderItemRepository.getOrderItemd(order_id);
	
	    return orderItems.stream()
                .map(orderItem -> {
                    Product product = productRepository.getProductById(orderItem.getProduct().getId());

                    OrderItemDto response = new OrderItemDto();
                    response.setId(orderItem.getId());
                    response.setOrderId(orderItem.getId());
                    response.setProductId(orderItem.getProduct().getId());
                    response.setName(product.getName());
                    response.setQuantity(orderItem.getQuantity());
                    response.setImageUrl(product.getImageUrl());

                    return response;
                })
                .collect(Collectors.toList());
    }
	

	//Method created to save orderItems
	public void saveOrderItems(Long orderId, List<OrderItemDto> orderItems) {
		orderItems.stream()
        .map(orderItemDTO -> {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(new Order(orderId, orderId, null, null, null, null, null)); 
            orderItem.setProduct(new Product(orderItemDTO.getProductId(), orderItemDTO.getName(), orderId, orderItemDTO.getImageUrl(), null, null, null));
            orderItem.setQuantity(orderItemDTO.getQuantity());
            return orderItem;
        })
        .forEach(orderItemRepository::save);
    }

}
