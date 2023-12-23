package system;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ServerTest {

	@Autowired
	private Server server1;
	
	
	
	
	@Test
	public void testServerStart() {
		server1.start();
		assertTrue(server1.isRunning());
	}
	
	@Test
	public void testServerStop() {
		server1.stop();
		assertFalse(server1.isRunning());
	}
}