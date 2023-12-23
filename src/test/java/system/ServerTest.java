package system;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ServerTest {

	
	private Server server = new Server("Terraria");
	
	@Test
	public void changeServerState() {
		
		server.start();
		assertTrue(server.isRunning());
	}
	
}