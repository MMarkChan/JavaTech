package mongodb.order;


import mongodb.model.Order;

import java.util.List;

public interface OrderOperations {
    List<Order> findOrdersByType(String t);
}
