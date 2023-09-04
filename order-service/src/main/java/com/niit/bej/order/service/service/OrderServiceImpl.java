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
    public Order findOrderByIdForCustomer(String email, long id) throws EmptyDatabaseException, OrderNotFoundException, CustomerNotFoundException {
        Optional<Customer> optionalCustomer = this.orderRepository.findCustomerByEmail(email);
        if (optionalCustomer.isPresent()) {
            Customer customerInDatabase = optionalCustomer.get();
            List<Order> ordersByCustomer = this.orderRepository.findAllOrdersByCustomer(customerInDatabase.getEmail());
            if (ordersByCustomer.isEmpty()) {
                throw new EmptyDatabaseException("No Orders present to search");
            } else {
                Order searchedOrder = null;
                for (Order order : ordersByCustomer) {
                    if (order.getId() == id) {
                        searchedOrder = order;
                    } else {
                        throw new OrderNotFoundException("Order with ID: " + id + " not found");
                    }
                }
                return searchedOrder;
            }
        } else {
            throw new CustomerNotFoundException("Customer bearing Email: " + email + " not found");
        }
    }

    @Override
    public List<Order> findAllOrdersOfCustomer(String email) throws EmptyDatabaseException, CustomerNotFoundException {
        Optional<Customer> optionalCustomer = this.orderRepository.findCustomerByEmail(email);
        if (optionalCustomer.isPresent()) {
            Customer customerInDatabase = optionalCustomer.get();
            List<Order> ordersByCustomer = this.orderRepository.findAllOrdersByCustomer(customerInDatabase.getEmail());
            if (ordersByCustomer.isEmpty()) {
                throw new EmptyDatabaseException("No Orders present to search");
            } else {
                return ordersByCustomer;
            }
        } else {
            throw new CustomerNotFoundException("Customer bearing Email: " + email + " not found");
        }
    }

    @Override
    public boolean removeOrderForCustomer(String email, long id) throws EmptyDatabaseException, OrderNotFoundException, CustomerNotFoundException {
        Optional<Customer> optionalCustomer = this.orderRepository.findCustomerByEmail(email);
        if (optionalCustomer.isPresent()) {
            Customer customerInDatabase = optionalCustomer.get();
            List<Order> ordersByCustomer = this.orderRepository.findAllOrdersByCustomer(customerInDatabase.getEmail());
            if (ordersByCustomer.isEmpty()) {
                throw new EmptyDatabaseException("No Orders present to search");
            } else {
                boolean isOrderDeleted = false;
                for (Order order : ordersByCustomer) {
                    if (order.getId() == id) {
                        this.orderRepository.deleteById(id);
                        isOrderDeleted = true;
                    } else {
                        throw new OrderNotFoundException("Order with ID: " + id + " not found");
                    }
                }
                return isOrderDeleted;
            }
        } else {
            throw new CustomerNotFoundException("Customer bearing Email: " + email + " not found");
        }
    }

    @Override
    public Address modifyDeliveryAddress(String email, long id, Address address) throws OrderNotFoundException, EmptyDatabaseException, CustomerNotFoundException {
        Optional<Customer> optionalCustomer = this.orderRepository.findCustomerByEmail(email);
        if (optionalCustomer.isPresent()) {
            Order recentOrder = this.findOrderByIdForCustomer(email, id);
            Address addressToBeDelivered = recentOrder.getDeliveryAddress();

            addressToBeDelivered.setFlatDetails(address.getFlatDetails());
            addressToBeDelivered.setSoceityName(address.getSoceityName());
            addressToBeDelivered.setSector(address.getSector());

            return this.orderRepository.changeDeliveryAddress(addressToBeDelivered);
        } else {
            throw new CustomerNotFoundException("Customer bearing Email: " + email + " not found");
        }
    }
}
