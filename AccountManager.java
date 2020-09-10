/* AccountManager: Creates, maintains and validates Users and Balances */
package com.transcognit.digifiatsim;

import org.apache.commons.lang3.RandomStringUtils;



public class AccountManager {
  User users[];
  public AccountManager() {
    users = new User[1000];
    /* Connect to database here, but a file for simulator */
    createUsers(); /* Create pool of 1000 users */
  }

  private void createUsers() {
    for (int i=0; i<1000; i++) {
      users[i] = new IUser(""+(1000*i+i),RandomStringUtils.random(15, True, False));
    }
  }

class IUser implements User {
  String id, name, publickey;

  public IUser(String id, String name) {
    this.id = id;
    this.name=name;
    this.publickey = "";
  }

  public String getName() {
    return name;
  }

  public String getID() {
    return id;
  }

  public String getPublicKey() {
    return publickey;
  }
}

  public static void main(String s[]) {

  }
}
