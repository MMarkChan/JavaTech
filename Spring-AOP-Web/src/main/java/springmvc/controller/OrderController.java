package springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springmvc.model.Order;
import springmvc.service.OrderService;

@Controller
public class OrderController {
	@Autowired
	private OrderService orderService;

	@RequestMapping("/getOrders")
	public String getOrders(Model model, @RequestParam("id") int id) {
		Order order = orderService.getOrder(id);
		model.addAttribute("order", order);
		
		return "showOrder";
	}
}
