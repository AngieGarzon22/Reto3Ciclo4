package com.usa.ciclo4.reto2ciclo4.controller;

import com.usa.ciclo4.reto2ciclo4.model.Order;
import com.usa.ciclo4.reto2ciclo4.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/order")
@CrossOrigin("*")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/all")
    public List<Order> getAllOrder(){
        return orderService.getAllOrder();
    }

    @GetMapping("/{idOrder}")
    public Optional<Order> getOrder(@PathVariable("idOrder") Integer id){
        return orderService.getOrder(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Order save(@RequestBody Order order){
        return orderService.save(order);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Order update(@RequestBody Order order){
        return orderService.update(order);
    }

    @DeleteMapping("/{idOrder}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("idOrder") Integer id){
        return orderService.delete(id);
    }

    @GetMapping("/zona/{zone}")
    public List<Order> getOrderByZone(@PathVariable("zone")String zone){
        return orderService.getOrderByZone(zone);
    }
}


