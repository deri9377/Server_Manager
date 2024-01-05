package system.Controllers;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import system.Controllers.Server;
import system.Controllers.ServerRepository;

@SpringBootTest
public class ServerRepositoryTest {
    
    @Autowired
    private ServerRepository repository;


    @Test
    public void saveServerTest() {
        repository.save(new Server("Terraria"));
        Server server = repository.getAll().get(0);

        assertTrue(server.getGame().equals("Terraria"));
        assertTrue(server.getId() == 1);

    }

    @Test
    public void deleteServerTest() {
        repository.save(new Server("Terraria"));
        Server server = repository.getAll().get(0);

        Long id = server.getId();

        repository.deleteById(id);

        assertNull(repository.findById(id));
    }

    @Test
    public void updateServerTest() {
        repository.save(new Server("Terraria"));
        Server server = repository.getAll().get(0);

        Server newServer = new Server("Ark");
        repository.update(newServer, server.getId());

        assertTrue(repository.findById(server.getId()).getGame().equals("Ark"));
        assertTrue(repository.findById(server.getId()).getId() == server.getId());
    }

    @Test
	public void testUniqueId() {

        repository.save(new Server("Terraria"));
        repository.save(new Server("Ark"));
        repository.save(new Server("Minecraft"));

        ArrayList<Server> servers = repository.getAll();
        Server server1 = servers.get(0);
        Server server2 = servers.get(1);
        Server server3 = servers.get(2);

		assertAll(
			"Assert Sever Id's Unique",
			() -> assertTrue(server1.getId() != server2.getId()),
			() -> assertTrue(server1.getId() != server3.getId()),
			() -> assertTrue(server2.getId() != server3.getId())
		);
	}
}
