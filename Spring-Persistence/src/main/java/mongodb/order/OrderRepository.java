package mongodb.order;

import mongodb.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends MongoRepository<Order, String>,OrderOperations {
    List<Order> findByCustomer(String c);
    List<Order> findByCustomerLike(String c);
    List<Order> findByCustomerAndType(String c, String t);
    List<Order> findByCustomerLikeAndType(String c, String t);
    int countByCustomer(String c);
    List<Order> findSomeStuffWeNeedByCustomer(String c);
    Order findASingleOrderByCustomer(String c);

    @Query("{'customer': 'ChenDongMing', 'type' : ?0}")
    List<Order> findChenDongMingsOrders(String t);
}
