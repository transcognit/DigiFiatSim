package digifiatsim;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.border.*;
import org.apache.commons.lang3.*;
import java.io.*;
import java.util.Collections;


class UserManager2 implements ActionListener{
  MainWindow m;
  IUser users[];
  int MAXCOUNT=1000;
  static Boolean firstRun = Boolean.TRUE;

  public UserManager2(MainWindow m1) {
    this.m = m1;
    users = new IUser[MAXCOUNT];
    createUsers();
    m.UserCountLabel.setText(""+MAXCOUNT);
  }
  public void actionPerformed(ActionEvent ev) {
    try {
      // One user transaction per second
      // Pack two random users and a random amount into
      // an AccountTransaction Object
      // Get a PSP and submitTransaction
      AccountTransaction tx = createTransaction();
      m.pars.User_TxCount++;
      m.pars.User_TxValue += tx.getValue();
      boolean status = m.getPSP().submitTransaction(tx);
      if (!status) {
        System.out.println("Tx failure: "+tx.toString());
      }
      m.UserManagerLabel1.setText(""+m.pars.User_TxCount);
      m.UserManagerLabel2.setText(""+m.pars.User_TxValue);

      // m.UserManagerLabel1.setText(""+(int)(Math.random() * 5000 + 1));
      // m.UserManagerLabel2.setText(""+(int)(Math.random() * 50000 + 1));

    } catch(Exception e) {
      //System.out.println("Error in UserManager: " + e.printStac());
      e.printStackTrace();
    }
  }

  public AccountTransaction createTransaction() {
    IUser u1 = users[RandomInt.getRandomInt(MAXCOUNT-1)];
    IUser u2 = users[RandomInt.getRandomInt(MAXCOUNT-1)];
    while (u1.equals(u2)) {
      u2 = users[RandomInt.getRandomInt(MAXCOUNT-1)];
    }
    int amount = RandomInt.getRandomInt(100000);
    return new AccountTransaction(u1, u2, (long)amount);
  }

  private void createUsers() {
    Long l;
    String s;
    int k;

    for (int i=0; i<MAXCOUNT; i++) {
      k = i + 1;
      s = RandomStringUtils.random(15, Boolean.TRUE, Boolean.FALSE);
      l = (Math.round(Math.random()*10000+100));
      users[i] = new IUser(""+(1000*k+k), s, l);
      if (i%100 == 0) {
        System.out.println(users[i]);
      }
    }
  }
}
