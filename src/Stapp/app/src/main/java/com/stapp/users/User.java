package com.stapp.users;

import com.stapp.databasehelpers.UserHelper;
import com.stapp.exceptions.UserAlreadyExistsException;
import com.stapp.exceptions.UserNotFoundException;
import com.stapp.security.PasswordHelpers;

/**
 * Created by rahulkumar1998 on 2017-10-22.
 */

public class User {

  private String username;
  private boolean loggedIn = false;

  public static boolean exists(String username) {
    return UserHelper.userExists(username);
  }

  /**
   * USE THIS TO LOG IN AN EXISTING USER
   */
  public User(String username, String password) throws UserNotFoundException {
    this.username = username;
    login(password);
  }

  /**
   * USE THIS TO CREATE A NEW USER
   */
  public User(String username, String name, String password, int roleId) {
    this.username = username;
    try {
      UserHelper.insertUser(username, name, password, roleId);
      login(password);
    } catch (UserAlreadyExistsException | UserNotFoundException e) {
      // shouldn't happen
    }
  }

  private boolean login(String password) throws UserNotFoundException {
    String hashedPass = UserHelper.getPassword(username);
    loggedIn = PasswordHelpers.comparePassword(hashedPass, password);
    return loggedIn;
  }

  /**
   * Ignoring exceptions in the following methods for these reasons:
   * 1. On creating a User Object the User gets logged in, so there should be no chance that the
   *    User does not exist or is not logged in
   * 2. The exceptions are used for when you manually do something with the UserHelper class, if you
   *    use these methods it should be all good!
   */


  // SELECTORS

  public String getName() {
    try {
      return UserHelper.getName(username);
    } catch (UserNotFoundException e) {
      // Shouldn't happen
    }
    return null;
  }

  public String getRoleName() {
    try {
      return UserHelper.getRoleNameGivenUsername(username);
    } catch (UserNotFoundException e) {
      // Shouldn't happen
    }
    return null;
  }

  /**
   * Returns the HASHED password stored in database.
   */
  public String getPassword() {
    try {
      return UserHelper.getPassword(username);
    } catch (UserNotFoundException e) {
      // Shouldn't happen
    }
    return null;
  }

  // UPDATERS

  public boolean updatePassword(String password) {
    try {
      return UserHelper.updatePassword(password, username);
    } catch (UserNotFoundException e) {
      // Shouldn't happen
    }
    return false;
  }

  public boolean updateName(String name) {
    try {
      return UserHelper.updateName(name, username);
    } catch (UserNotFoundException e) {
      // Shouldn't happen
    }
    return false;
  }

  public boolean updateRole(String roleName) {
    try {
      return UserHelper.updateRole(roleName, username);
    } catch (UserNotFoundException e) {
      // Shouldn't happen
    }
    return false;
  }

}
