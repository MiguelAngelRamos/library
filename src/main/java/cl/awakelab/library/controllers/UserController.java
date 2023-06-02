package cl.awakelab.library.controllers;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.google.gson.Gson;

import cl.awakelab.library.conexion.DBConnection;
import cl.awakelab.library.controllers.interfaces.IUserController;
import cl.awakelab.library.model.entity.User;

public class UserController implements IUserController {

  @Override
  public String login(String username, String password) {
    
    Gson gson = new Gson();
    DBConnection conexion = DBConnection.getInstance();
    
    String sql = "SELECT * FROM users WHERE username = ?";
    
    try {
      PreparedStatement statement = conexion.getConnection().prepareStatement(sql);
      statement.setString(1, username);
      
      ResultSet rs = statement.executeQuery();
      
      while(rs.next()) {
        String storedPassword = rs.getString("password");
        
        if(verifyPassword(password,storedPassword )) {
          String name = rs.getString("username");
          User user = new User(name, "");
          return gson.toJson(user);
        }
    
      }
      
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    
    return "false";
  }
  
  private boolean verifyPassword(String plainPassword, String hashedPassword) {
    try {
      MessageDigest md = MessageDigest.getInstance("SHA-256");
      md.update(plainPassword.getBytes());
      byte [] digest = md.digest(); // Ya genera el Hash
      String hashedPlainPassword = String.format("%064x", new BigInteger(1,digest));
      return hashedPlainPassword.equals(hashedPassword);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return false;
  }

  @Override
  public void register(String username, String password) {
    
    DBConnection conexion = DBConnection.getInstance();
    
    String sql = "INSERT INTO users (username, password) VALUES ( ? , ?)";
    
    try {
      
      MessageDigest md = MessageDigest.getInstance("SHA-256");
      md.update(password.getBytes());
      byte [] digest = md.digest(); // Ya genera el Hash
      
      String hashedPassword = String.format("%064x", new BigInteger(1,digest));
      PreparedStatement preparedStatement = conexion.getConnection().prepareStatement(sql);
      preparedStatement.setString(1, username);
      preparedStatement.setString(2, hashedPassword);
      preparedStatement.executeUpdate();
      
      
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    
  }

}
