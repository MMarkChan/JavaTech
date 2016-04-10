package springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springmvc.model.Client;
import springmvc.repository.ClientRepository;

@Service("clientService")
public class ClientServiceImpl implements ClientService {
	@Autowired
	private ClientRepository clientRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Client getClient(int id) {
		return clientRepository.getClient(id);
	}
}
