package digifiatsim;


import org.apache.commons.lang3.*;
import java.io.*;


public class AccountManager {
  IUser users[];
  int k;
  long balance; // The balance in this account

  public AccountManager() {
    users = new IUser[1000];
    /* Connect to database here, but a file for simulator */
    createUsers(); /* Create pool of 1000 users */
  }

  private void createUsers() {
    for (int i=0; i<1000; i++) {
      k = i + 1;
      users[i] = new IUser(
        ""+(1000*k+k),
        RandomStringUtils.random(15, Boolean.TRUE, Boolean.FALSE),
        (long)(Math.random()*10000+100)
        );
      if (i%100 == 0) {
        System.out.println(users[i]);
      }
    }
  }

class IUser implements User {
  String id, name, publickey;
  long balance;

  public IUser(String id, String name, long balance) {
    this.id = id;
    this.name=name;
    this.balance = balance;
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

  public long getBalance() {
    return balance;
  }

  public String toString() {
    return "I am "+name+" ("+id+") and my balance is: "+balance;
  }
}


public static void main(String s[]) {
    new AccountManager();
  }
}
