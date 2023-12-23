package system;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.context.annotation.Configuration;

@Configuration
@Entity
class Server {

  private @Id @GeneratedValue Long id;
  private String game;
  private boolean running;
  
	public Server() {

	}

  	public Server(String game) {
  		this.game = game;
  		running = false;
  	}	

  	public Long getId() {
  		return this.id;
  	}

	public String getGame() {
		return this.game;
	}
  
	public void setGame(String game) {
		this.game = game;
	}


	public void setId(Long id) {
		this.id = id;
	}
  
	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}


	@Override
	public String toString() {
		return "Employee{" + "id=" + this.id + ", name='" + this.game + ", status=" + this.running + '}' + "\n";
	}

	public Object map(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	public void stop() {
		// TODO Auto-generated method stub
		setRunning(false);
	}
	
	public void start() {
		setRunning(true);
	}


}