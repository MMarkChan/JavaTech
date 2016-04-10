package springmvc.repository;

import springmvc.model.Client;

public interface ClientRepository {
	public Client getClient(int id);
}
