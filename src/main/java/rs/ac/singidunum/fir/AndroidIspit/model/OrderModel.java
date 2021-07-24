package rs.ac.singidunum.fir.AndroidIspit.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "order")
public class OrderModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="order_id")
    private int orderId;

    @Column(name="created_at")
    private String name;

    @ManyToOne
    @JoinColumn(name="account_id")
    private AccountModel accountId;

    @JsonIgnore
    @OneToMany(mappedBy = "orderBoId", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OrderBookModel> orderBookModel = new HashSet<OrderBookModel>();

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AccountModel getAccountId() {
        return accountId;
    }

    public void setAccountId(AccountModel accountId) {
        this.accountId = accountId;
    }

    public Set<OrderBookModel> getOrderBookModel() {
        return orderBookModel;
    }

    public void setOrderBookModel(Set<OrderBookModel> orderBookModel) {
        this.orderBookModel = orderBookModel;
    }
}
