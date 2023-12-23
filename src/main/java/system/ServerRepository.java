package system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
class ServerRepository {
	
	private Long employeeCounter = (long) 1;
	private HashMap<Long, Server> repo;
	
	public ServerRepository() {
		repo = new HashMap<Long, Server>();
	}

	public Server save(Server employee) {
		// TODO Auto-generated method stub
		employee.setId(employeeCounter);
		repo.put(employeeCounter++, employee);
		return employee;
	}
	
	public ArrayList<Server> getAll() {
		ArrayList<Server> list = new ArrayList<>();
		for (Map.Entry<Long, Server> i : repo.entrySet()) {
			list.add(i.getValue());
		}
		
		return list;
	}

	public Server findById(Long id) {
		// TODO Auto-generated method stub
		return repo.get(id);
	}

	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		repo.remove(id);
	}

	public Server update(Server server, Long id) {
		// TODO Auto-generated method stub
		server.setId(id);
		return repo.replace(id, server);
	}

}