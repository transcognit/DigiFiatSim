package digifiatsim;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.border.*;

import org.apache.commons.lang3.*;
import java.io.*;
import java.util.Collections;


class UserManager extends TimerTask {
  MainWindow m;
  IUser users[];
  int MAXCOUNT=1000;

  public UserManager(MainWindow m1) {
    this.m = m1;
    users = new IUser[MAXCOUNT];
    loadUsers();
  }
  public void run() {
    try {
      // One user transaction per second
      // Pack two random users and a random amount into
      // an AccountTransaction Object
      // Get a PSP and submitTransaction
      AccountTransaction tx = createTransaction();
      boolean status = m.getPSP().submitTransaction(tx);
      if (!status) {
        System.out.println("Tx failure: "+tx.toString());
      }


      // m.UserManagerLabel1.setText(""+(int)(Math.random() * 5000 + 1));
      // m.UserManagerLabel2.setText(""+(int)(Math.random() * 50000 + 1));
      Thread.sleep(1000);
    } catch(Exception e) {}
  }

  public AccountTransaction createTransaction() {
    IUser u1 = users[RandomInt.getRandomInt(1000)];
    IUser u2 = users[RandomInt.getRandomInt(1000)];
    while (!u1.equals(u2)) {
      u2 = users[RandomInt.getRandomInt(1000)];
    }
    int amount = RandomInt.getRandomInt(100000);
    return new AccountTransaction(u1, u2, (long)amount);
  }

  public void loadUsers() {
    try {
      FileInputStream infile = new FileInputStream("accounts.ser");
      ObjectInputStream inobj = new ObjectInputStream(infile);
      for (int i=0; i < MAXCOUNT; i++) {
        users[i] = (IUser)inobj.readObject();
      }
    } catch(Exception e) {
      System.out.println("Error: "+e.getMessage());
      System.exit(0);
    }
    m.UserCountLabel.setText(""+MAXCOUNT);
  }
}
