/**
 * Created by Momo on 9/23/17
 */

import java.util.*;

public static class User {
  private String userName;
  private String serviceType;

  public User(String userName, String serviceType){
    this.userName = userName;
    this.serviceType = serviceType;
  }

  public String getUserName(){
    return this.userName;
  }

  public String getServiceType(){
    return this.serviceType;
  }

}
