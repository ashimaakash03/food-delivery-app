package com.niit.bej.order.service.service;

import com.niit.bej.order.service.exception.CustomerNotFoundException;
import com.niit.bej.order.service.exception.EmptyDatabaseException;
import com.niit.bej.order.service.exception.OrderNotFoundException;
import com.niit.bej.order.service.model.Address;
import com.niit.bej.order.service.model.Customer;
import com.niit.bej.order.service.model.Order;
import com.niit.bej.order.service.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order addOrderForCustomer(String email, Order order) throws CustomerNotFoundException {
        Optional<Customer> optionalCustomer = this.orderRepository.findCustomerByEmail(email);
        if (optionalCustomer.isPresent()) {
            Customer customerInDatabase = optionalCustomer.get();
            List<Order> orderByCustomer = this.orderRepository.findAllOrdersByCustomer(customerInDatabase.getEmail());
            orderByCustomer.add(order);
            return order;
        } else {
            throw new CustomerNotFoundException("Customer bearing Email: " + email + " not found");
        }
    }

    @Override
    public Order findOrderByIdForCustomer(String email, long id) throws OrderNotFoundException, CustomerNotFoundException {
        Optional<Customer> optionalCustomer = this.orderRepository.findCustomerByEmail(email);
        if (optionalCustomer.isPresent()) {
            Customer customerInDatabase = optionalCustomer.get();
            List<Order> ordersByCustomer = this.orderRepository.findAllOrdersByCustomer(customerInDatabase.getEmail());
            if (ordersByCustomer.isEmpty()) {
                throw new EmptyDatabaseException();
            }

        }
    }

    @Override
    public List<Order> findAllOrdersOfCustomer(String email) {
        return null;
    }

    @Override
    public Order updateOrderOfCustomer(String email, Order order) {
        return null;
    }

    @Override
    public boolean removeOrderForCustomer(String email, long id) {
        return false;
    }

    @Override
    public Address modifyDeliveryAddress(String email, Address address) {
        return null;
    }
}
