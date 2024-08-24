package package1.domain.entity;

import ch.qos.logback.core.net.server.Client;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

public class OrderEntity {
    private Integer id;
    private Client client;
    private LocalDate orderDate;
    private BigDecimal orderAmount;
    private ArrayList<OrderItemEntity> orderItems;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }
}
