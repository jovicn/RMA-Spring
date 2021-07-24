package rs.ac.singidunum.fir.AndroidIspit.model;

import javax.persistence.*;

@Entity
@Table(name = "order_book")
public class OrderBookModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_book_id")
    private int orderBookId;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderModel orderBoId;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private BookModel bookOrderId;

    public int getOrderBookId() {
        return orderBookId;
    }

    public void setOrderBookId(int orderBookId) {
        this.orderBookId = orderBookId;
    }

    public OrderModel getOrderBoId() {
        return orderBoId;
    }

    public void setOrderBoId(OrderModel orderBoId) {
        this.orderBoId = orderBoId;
    }

    public BookModel getBookOrderId() {
        return bookOrderId;
    }

    public void setBookOrderId(BookModel bookOrderId) {
        this.bookOrderId = bookOrderId;
    }
}
