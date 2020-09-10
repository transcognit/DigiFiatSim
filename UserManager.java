import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.border.*;

class UserManager extends TimerTask {
  MainWindow m;

  public UserManager(MainWindow m1) {
    this.m = m1;
  }
  public void run() {
    try {
      m.UserManagerLabel1.setText(""+(int)(Math.random() * 5000 + 1));
      m.UserManagerLabel2.setText(""+(int)(Math.random() * 50000 + 1));
      //Thread.sleep(500);
    } catch(Exception e) {}
  }
}
