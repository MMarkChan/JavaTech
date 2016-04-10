package mongodb;

import mongodb.config.MongoConfig;
import mongodb.model.Item;
import mongodb.model.Order;
import mongodb.order.OrderRepository;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class MongoDBTest {
    @Test
    public void test(){
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MongoConfig.class);
        OrderRepository repository = (OrderRepository)context.getBean("orderRepository");
        Order order = new Order();
        order.setId("order0004");
        order.setCustomer("ChenDongMing80");
        order.setType("WEB");
        List<Item> items = new ArrayList<Item>();
        Item item = new Item();
        item.setId(001L);
//        item.setOrder(order);
        item.setPrice(88);
        item.setProduct("饮料");
        item.setQuantity(5);
        items.add(item);
        order.setItems(items);
        repository.save(order);

        Order rs = repository.findOne("order0002");

        List<Order> orders = repository.findByCustomer("ChenDongMing");

        orders = repository.findChenDongMingsOrders("Tom2");

        orders = repository.findOrdersByType("NET");
        System.out.println();
    }
}
