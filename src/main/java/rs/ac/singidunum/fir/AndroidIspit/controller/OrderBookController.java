package rs.ac.singidunum.fir.AndroidIspit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.ac.singidunum.fir.AndroidIspit.model.OrderBookModel;
import rs.ac.singidunum.fir.AndroidIspit.repository.OrderBookRepository;

import java.util.List;

@RestController
public class OrderBookController {

    @Autowired(required = false)
    private OrderBookRepository orderBookRepository;

    @GetMapping("/order-book")
    public List<OrderBookModel> showOrderBooks(){
        return (List<OrderBookModel>) orderBookRepository.findAll();
    }

    @GetMapping("/order-book/{id}")
    public OrderBookModel showOrderBook(@PathVariable int id) {
        return orderBookRepository.findById(id).orElse(null);
    }

    @PostMapping("/order-book")
    public OrderBookModel createOrderBook(@RequestBody OrderBookModel orderBookModel){
        return orderBookRepository.save(orderBookModel);
    }

    @DeleteMapping("/order-book/{id}")
    public boolean delete(@PathVariable int id){
        orderBookRepository.deleteById(id);
        return true;
    }

    @PutMapping("/order-book/{id}")
    public OrderBookModel updateOrderBook(@PathVariable int id, @RequestBody OrderBookModel newOrderBook){
        OrderBookModel ordBook = orderBookRepository.findById(id).orElse(null);
        ordBook.setOrderBoId(newOrderBook.getOrderBoId());
        ordBook.setBookOrderId(newOrderBook.getBookOrderId());

        return orderBookRepository.save(ordBook);
    }

}



