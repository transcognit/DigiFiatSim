package digifiatsim;

import java.io.*;

class IUser implements User, Serializable {
  String id, name, publickey;
  Long balance;

  public IUser(String id, String name, Long balance) {
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

  public Long getBalance() {
    return balance;
  }

  public String toString() {
    return "I am "+name+" ("+id+") and my balance is: "+balance;
  }
  /*
  boolean transferFrom(Long amount) {
    return Boolean.FALSE;
  }
  boolean transferTo(Long amount) {
    return Boolean.FALSE;
  } */
}
