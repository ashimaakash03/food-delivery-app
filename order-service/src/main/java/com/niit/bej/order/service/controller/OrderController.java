package com.niit.bej.order.service.controller;

import com.niit.bej.order.service.exception.CustomerNotFoundException;
import com.niit.bej.order.service.exception.EmptyDatabaseException;
import com.niit.bej.order.service.exception.OrderNotFoundException;
import com.niit.bej.order.service.model.Address;
import com.niit.bej.order.service.model.Order;
import com.niit.bej.order.service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/add/{email}")
    public ResponseEntity<?> addOrderForCustomer(@RequestBody Order order, @PathVariable String email) {
        try {
            Order newOrder = this.orderService.addOrderForCustomer(email, order);
            return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
        } catch (CustomerNotFoundException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get/{email}/{id}")
    public ResponseEntity<?> findOrderByIdForCustomer(@PathVariable String email, @PathVariable long id) {
        try {
            Order searchedOrder = this.orderService.findOrderByIdForCustomer(email, id);
            return new ResponseEntity<>(searchedOrder, HttpStatus.FOUND);
        } catch (OrderNotFoundException | CustomerNotFoundException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
        } catch (EmptyDatabaseException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/get/{email}")
    public ResponseEntity<?> findAllOrdersByCustomer(@PathVariable String email) {
        try {
            List<Order> allOrders = this.orderService.findAllOrdersOfCustomer(email);
            return new ResponseEntity<>(allOrders, HttpStatus.FOUND);
        } catch (EmptyDatabaseException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NO_CONTENT);
        } catch (CustomerNotFoundException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{email}/{id}")
    public ResponseEntity<?> removeOrderForCustomer(@PathVariable String email, @PathVariable long id) {
        try {
            this.orderService.removeOrderForCustomer(email, id);
            return new ResponseEntity<>("Order with ID: " + id + " removed for customer with email: " + email, HttpStatus.OK);
        } catch (OrderNotFoundException | CustomerNotFoundException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
        } catch (EmptyDatabaseException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping("/update/{email}/{id}")
    public ResponseEntity<?> updateDeliveryAddress(@RequestBody Address address, @PathVariable String email, @PathVariable long id) {
        try {
            Address modifiedAddress = this.orderService.modifyDeliveryAddress(email, id, address);
            return new ResponseEntity<>(modifiedAddress, HttpStatus.OK);
        } catch (OrderNotFoundException | CustomerNotFoundException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
        } catch (EmptyDatabaseException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NO_CONTENT);
        }
    }
}