package system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
  

  @Bean
  CommandLineRunner initDatabase(ServerRepository repository) {

    return args -> {
      log.info("Preloading " + repository.save(new Server("Terraria")));
      log.info("Preloading " + repository.save(new Server("Ark")));
    };
  }
}