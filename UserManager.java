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
      m.UserManagerLabel1.setText(""+(int)(Math.random() * 5000 + 1));
      m.UserManagerLabel2.setText(""+(int)(Math.random() * 50000 + 1));
      //Thread.sleep(500);
    } catch(Exception e) {}
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
