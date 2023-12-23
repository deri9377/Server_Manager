package system;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
class ServerModelAssembler implements RepresentationModelAssembler<Server, EntityModel<Server>> {

  @Override
  public EntityModel<Server> toModel(Server employee) {

    return EntityModel.of(employee, //
        linkTo(methodOn(ServerController.class).getServer(employee.getId())).withSelfRel(),
        linkTo(methodOn(ServerController.class).all()).withRel("server"));
  }
}