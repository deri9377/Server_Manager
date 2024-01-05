package system.Controllers;

import java.io.IOException; 
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
class ServerController {

  private final ServerRepository repository;

  private final ServerModelAssembler assembler;

  ServerController(ServerRepository repository, ServerModelAssembler assembler) {
    this.repository = repository;
    this.assembler = assembler;
  }


  // Aggregate root
  // tag::get-aggregate-root[]
  @GetMapping("/server")
  CollectionModel<EntityModel<Server>> all() {
	  
	  List<EntityModel<Server>> servers = repository.getAll().stream()
		      .map(assembler::toModel)
		      .collect(Collectors.toList());

		  return CollectionModel.of(servers, linkTo(methodOn(ServerController.class).all()).withSelfRel());
  }
  // end::get-aggregate-root[]

  @PostMapping("/server")
  ResponseEntity<?> newServer(@RequestBody Server newEmployee) {
    EntityModel<Server> entityModel = assembler.toModel(repository.save(newEmployee));

    return ResponseEntity //
        .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
        .body(entityModel);
  }

  // Single item
  
  @GetMapping("/server/{id}")
  EntityModel<Server> getServer(@PathVariable Long id) {
    
	Server server = repository.findById(id);
	if (server == null) {
		throw new ServerNotFoundException(id);
	}
	
	return assembler.toModel(server);
  }



@GetMapping("/server/{id}/stop")
  Server stopServer(@PathVariable Long id) {
	  Server server = repository.findById(id);
	  server.stop();
	  // TODO: Stop server on the terminal
	  
	  
	  
	  return server;
  }
  
  @GetMapping("/server/{id}/start")
  Server startServer(@PathVariable Long id) throws IOException {
	  Server server = repository.findById(id);
	  server.start();
	  // TODO: Start server on terminal

	  Process process = new ProcessBuilder("/bin/bash", "-c", "echo Hello World").start();        
	  String results = InputReader.readOutput(process.getInputStream());
	  System.out.println(results);
	  return server;
  }
    
  

  @DeleteMapping("/server/{id}")
  void deleteEmployee(@PathVariable Long id) {
    repository.deleteById(id);
    // TODO: delete container on terminal
  }
}