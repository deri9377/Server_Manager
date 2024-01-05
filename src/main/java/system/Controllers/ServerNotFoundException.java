package system.Controllers;

class ServerNotFoundException extends RuntimeException {

  ServerNotFoundException(Long id) {
    super("Could not find employee " + id);
  }
}