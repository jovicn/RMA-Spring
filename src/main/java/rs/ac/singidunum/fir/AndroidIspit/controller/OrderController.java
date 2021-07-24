package rs.ac.singidunum.fir.AndroidIspit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.ac.singidunum.fir.AndroidIspit.model.OrderModel;
import rs.ac.singidunum.fir.AndroidIspit.repository.OrderRepository;

import java.util.List;

@RestController
public class OrderController {

    @Autowired(required = false)
    private OrderRepository orderRepository;

    @GetMapping("/order")
    public List<OrderModel> showOrders(){
        return (List<OrderModel>) orderRepository.findAll();
    }

    @GetMapping(path="/order/{id}")
    public OrderModel showOrder(@PathVariable int id) {
        return orderRepository.findById(id).orElse(null);
    }

    @PostMapping(path = "/order")
    public OrderModel createOrder(@RequestBody OrderModel ord){
        return orderRepository.save(ord);
    }

    @DeleteMapping("/order/{id]")
    public boolean delete(@PathVariable String id){
        int ordId = Integer.parseInt(id);
        orderRepository.deleteById(ordId);
        return true;
    }

    @PutMapping(path = "/order/{id}")
    public OrderModel updateOrder(@PathVariable int id, @RequestBody OrderModel om){
        OrderModel oa = orderRepository.findById(id).orElse(null);
        oa.setName(om.getName());

        return orderRepository.save(oa);
    }

}
