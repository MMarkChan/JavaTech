package springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springmvc.model.Order;
import springmvc.repository.OrderRepository;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Order getOrder(int id) {
		return orderRepository.getOrder(id);
	}
}
