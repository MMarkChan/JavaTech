package springmvc.repository;


import springmvc.model.Order;

public interface OrderRepository {
	public Order getOrder(int id);
}
