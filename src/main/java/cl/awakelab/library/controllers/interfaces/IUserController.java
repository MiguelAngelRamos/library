package cl.awakelab.library.controllers.interfaces;

public interface IUserController {
  public String login(String username, String password);
  public void register(String username, String password);
}
